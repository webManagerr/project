package test;

import org.radixware.web.manager.Node;

public abstract class NodeImplementation implements Node {

    private final String name;
    private Node parent = null;

    protected abstract String idUrl();

    protected abstract String idUrlParent();

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
