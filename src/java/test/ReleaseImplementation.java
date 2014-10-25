package test;
import java.io.IOException;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Release;
import org.radixware.manager.entry.DistributiveReleaseEntry;
import org.radixware.web.manager.Layers;
import org.tmatesoft.svn.core.SVNException;

public class ReleaseImplementation extends NodeImplementation implements Release
{
        private DistributiveReleaseEntry distributiveReleaseEntry;
        private String version = null;
        private String prevReleaseVersion = "";
        private String status;
    
	public ReleaseImplementation(DistributiveReleaseEntry dre , NodeImplementation parent) {
		super(dre.getDisplayName(),parent);
                this.distributiveReleaseEntry = dre;
                
	}

        private void initMembers()
        {
           try {
                version = distributiveReleaseEntry.getReleaseXml().getXml().getReleaseNumber();
                for(Integer i : distributiveReleaseEntry.getPrevReleaseNumber())
                {
                    prevReleaseVersion += String.valueOf(i)+"\n";
                }
                
                status = distributiveReleaseEntry.findReleaseStatus().getName();
            } catch (SVNException | IOException | XmlException ex) {
                throw new ProjectInfoAccessException(ex);
            }
        }
        
        
	@Override
	public String getVersion() {
            if(version == null)
            {
                initMembers();
            }
            return version;
	}

	@Override
	public String getPrevReleaseVersion() {
            if(version == null)
            {
                initMembers();
            }
            return prevReleaseVersion;
	}

	@Override
	public String getStatus() {
            if(version == null)
            {
                initMembers();
            }
           return status;
	}

    @Override
    public Layers getLayers() {
        return new BranchLayersImplementation(distributiveReleaseEntry);
    }

    @Override
    protected String idUrl() {
        return distributiveReleaseEntry.getURL().getPath();
    }

}