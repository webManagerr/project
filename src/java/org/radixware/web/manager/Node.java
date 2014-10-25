package org.radixware.web.manager;

public interface Node {
	public String getName();
	public String getId();
        public Node getParent();
        public Project getProjectParent();
}
