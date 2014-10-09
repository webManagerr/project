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


public class DistributionKitsImplementation extends DirImplementation implements DistributionKits
{
	private  List<DistributionKit> listDK = null;
        
	
	public DistributionKitsImplementation(ExternalProductImplementation parent) {
		
            super("Distribution Kits", parent);
            
	}

        @Override
        public NodeList getNodeList() {
            synchronized(this){
                if(listDK == null)
                {
                    try {
                    ProductDistributivesEntry pde = ((ExternalProductImplementation)super.getParent())
                            .getProductDistributivesEntry();
                    listDK = new ArrayList<>();
                    for(DistributiveEntry element : pde.getDistributives())
                    {
                        listDK.add(new DistributionKitImplementation(element, this));
                    }
                    super.setNodeList(new NodeListImplementation(listDK));
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
}
