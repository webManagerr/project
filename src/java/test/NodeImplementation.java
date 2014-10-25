package test;

import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;

public abstract class NodeImplementation implements Node {

    private final String name;
    private Node parent = null;

    protected abstract String idUrl();
    
    public  Project getProjectParent()
    {
        Node temp = parent;
        while(!temp.getClass().equals(ProjectImplementation.class))
        {
            temp = parent.getParent();
        }
        return (Project)temp;
    }

    public NodeImplementation(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        Project project = getProjectParent();
        if(project == null)
        {
            return "~" + idUrl();
        }
        return project.getId() + "~" + idUrl();
    }

    @Override
    public Node getParent() {
        return this.parent;
    }
}
