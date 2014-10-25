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

public class ExternalProductsImplementation extends DirImplementation<ExternalProduct> implements ExternalProducts {

    private ProjectImplementation projectParent = null;
    private List<ExternalProduct> externalProductList = null;
    private DistributivesEntry distributivesEntry = null;

    private List<ExternalProduct> upload() {
        try {
            List<ExternalProduct> result = new ArrayList<>();
            ProjectEntry entry;
            entry = projectParent.getProjectEntry();
            distributivesEntry = entry.getDistributives();

            for (ProductDistributivesEntry product : distributivesEntry.getProducts()) {
                ExternalProductImplementation rel = new ExternalProductImplementation(
                        product, this);
                result.add(rel);

            }
            return result;
        } catch (SVNException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }

    public ExternalProductsImplementation(ProjectImplementation ep) {
        super("External Products", ep);
        projectParent = ep;

    }

    @Override
    public NodeList getNodeList() {
        synchronized (this) {
            if (externalProductList == null) {
                externalProductList = upload();
                NodeListImplementation<ExternalProduct> nlExPr = new NodeListImplementation<>(externalProductList);
                super.setNodeList(nlExPr);
            }
        }
        return super.getNodeList();
    }

    @Override
    public Iterator<ExternalProduct> iterator() {
        return getNodeList().getNodes().iterator();
    }


    @Override
    protected String idUrl() {
        if(externalProductList == null)
        {
            getNodeList();
        }
        return distributivesEntry.getURL().getPath();
    }

}
