package test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.ExternalProducts;
import org.radixware.manager.entry.DistributivesEntry;
import org.radixware.manager.entry.ProductDistributivesEntry;
import org.radixware.manager.entry.ProjectEntry;
import org.radixware.web.manager.NodeList;
import org.tmatesoft.svn.core.SVNException;


public class ExternalProductsImplementation extends DirImplementation<ExternalProduct> implements ExternalProducts
{
    
    private ProjectImplementation project = null;
    private List<ExternalProduct> list = null;
    private List<ExternalProduct> upload() {
            try {
                List<ExternalProduct> result = new ArrayList<>();
                ProjectEntry entry;
                entry = project.getProjectEntry();
                DistributivesEntry de = entry.getDistributives();
                
                for(ProductDistributivesEntry product : de.getProducts()){
                   ExternalProductImplementation rel = new ExternalProductImplementation(
                    product , this);
                   result.add(rel);
                    
                }
                return result;
            } catch (SVNException ex) {
                Logger.getLogger(ExternalProductsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
            return Collections.emptyList();
       }

    public ExternalProductsImplementation(ProjectImplementation ep) {
        super("External Products", ep);
        project = ep;
        
    }

    @Override
    public  NodeList getNodeList() {
        synchronized(this){
            if(list == null)
            {
                list = upload();
                NodeListImplementation<ExternalProduct> nlExPr = new NodeListImplementation<>(list);
                super.setNodeList(nlExPr);
            }
        }
        return super.getNodeList();
    }
    
    @Override
    public Iterator<ExternalProduct> iterator() {
        return getNodeList().getNodes().iterator();
    }
}