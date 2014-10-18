package test;

import org.radixware.web.manager.Dir;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.NodeList;

public abstract class DirImplementation<T extends Node> extends NodeImplementation implements Dir {

    private NodeList<T> nodeList = null;

    public DirImplementation(String name, Node parent) {
        super(name, parent);
    }

    protected void setNodeList(NodeList<T> nl) {
        nodeList = nl;
    }

    @Override
    public NodeList getNodeList() {
        return nodeList;
    }

    @Override
    protected abstract String idUrl();

    @Override
    protected abstract String idUrlParent();
}
