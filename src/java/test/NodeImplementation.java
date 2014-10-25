package test;

import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;

public abstract class NodeImplementation implements Node {

    private final String name;
    private Node parent = null;

    protected abstract String idUrl();

    protected abstract String idUrlParent();
    
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
        return idUrlParent() + "~" + idUrl();
    }

    @Override
    public Node getParent() {
        return this.parent;
    }
}
