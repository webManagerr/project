package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Release;
import org.radixware.manager.entry.DistributiveReleaseEntry;
import org.radixware.manager.entry.LayerEntry;
import org.radixware.web.manager.Layer;
import org.radixware.web.manager.Layers;
import org.tmatesoft.svn.core.SVNException;

public class ReleaseImplementation extends NodeImplementation implements Release {

    private DistributiveReleaseEntry distributiveReleaseEntry;
    private String version = null;
    private String prevReleaseVersion = "";
    private String status;
    List<Layer> layers = null;

    public ReleaseImplementation(DistributiveReleaseEntry dre, NodeImplementation parent) {
        super(dre.getDisplayName(), parent);
        this.distributiveReleaseEntry = dre;

    }

    private void initMembers() {
        try {
            version = distributiveReleaseEntry.getReleaseXml().getXml().getReleaseNumber();
            for (Integer i : distributiveReleaseEntry.getPrevReleaseNumber()) {
                prevReleaseVersion += String.valueOf(i) + "\n";
            }

            status = distributiveReleaseEntry.findReleaseStatus().getName();
        } catch (SVNException | IOException | XmlException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }

    @Override
    public String getVersion() {
        if (version == null) {
            initMembers();
        }
        return version;
    }

    @Override
    public String getPrevReleaseVersion() {
        if (version == null) {
            initMembers();
        }
        return prevReleaseVersion;
    }

    @Override
    public String getStatus() {
        if (version == null) {
            initMembers();
        }
        return status;
    }

    @Override
    public Layers getLayers() {
        try {
            synchronized (this) {
                if (layers == null) {
                    layers = new ArrayList<>();
                    for (LayerEntry element : distributiveReleaseEntry.getLayers()) {
                        layers.add(new LayerImplementation(element));
                    }
                }
            }
            return new BranchLayersImplementation(layers);

        } catch (SVNException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }

    @Override
    protected String idUrl() {
        return distributiveReleaseEntry.getURL().getPath();
    }

}
