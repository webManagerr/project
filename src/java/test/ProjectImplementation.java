package test;

import org.radixware.web.manager.ExternalProducts;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;
import org.radixware.manager.entry.ProjectEntry;

public class ProjectImplementation extends NodeImplementation implements Project {

    private ExternalProducts externalProducts = null;
    private ProjectEntry projectEntry = null;

    public ProjectImplementation(ProjectEntry pe, Node parent) {
        super(pe.getDisplayName(), parent);
        this.projectEntry = pe;
    }

    @Override
    public ExternalProducts getExternalProducts() {
        synchronized (this) {
            if (this.externalProducts == null) {
                this.externalProducts = new ExternalProductsImplementation(this);
            }
        }
        return this.externalProducts;
    }

    public ProjectEntry getProjectEntry() {
        return this.projectEntry;
    }

    @Override
    public String getSvnHomeUrl() {
        return projectEntry.getURL().getProtocol() + "://" + projectEntry.getURL().getHost() + ":" + projectEntry.getURL().getPort() + projectEntry.getURL().getPath();
    }

    @Override
    protected String idUrl() {
        return projectEntry.getURL().getPath();
    }

    @Override
    public Project getProjectParent() {
        return this;
    }
}
