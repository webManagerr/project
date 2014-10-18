package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.radixware.web.manager.DistributionKit;
import org.radixware.web.manager.DistributionKits;
import org.radixware.manager.entry.DistributiveEntry;
import org.radixware.manager.entry.ProductDistributivesEntry;
import org.radixware.web.manager.NodeList;
import org.tmatesoft.svn.core.SVNException;

public class DistributionKitsImplementation extends DirImplementation implements DistributionKits {

    private List<DistributionKit> distributionKit = null;
    private ProductDistributivesEntry productDistributivesEntry = null;

    public DistributionKitsImplementation(ExternalProductImplementation parent) {

        super("Distribution Kits", parent);

    }

    @Override
    public NodeList getNodeList() {
        synchronized (this) {
            if (distributionKit == null) {
                try {
                    productDistributivesEntry = ((ExternalProductImplementation) super.getParent())
                            .getProductDistributivesEntry();
                    distributionKit = new ArrayList<>();
                    
                    for (DistributiveEntry element : productDistributivesEntry.getDistributives()) {
                        distributionKit.add(new DistributionKitImplementation(element, this));
                    }
                    super.setNodeList(new NodeListImplementation(distributionKit));
                } catch (SVNException ex) {
                    Logger.getLogger(DistributionKitsImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return super.getNodeList();
    }

    @Override
    public Iterator<DistributionKit> iterator() {
        return getNodeList().getNodes().iterator();
    }

    @Override
    protected String idUrl() {
        if (distributionKit == null) {
            getNodeList();
        }
        return productDistributivesEntry.getURL().getPath();
    }

    @Override
    protected String idUrlParent() {
        if (distributionKit == null){
            getNodeList();
        }
        return productDistributivesEntry.getParent().getURL().getPath();
    }
}
