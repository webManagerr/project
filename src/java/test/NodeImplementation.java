package test;


import org.radixware.web.manager.Node;

public class NodeImplementation implements Node{

	private final String name;
	private static int id;
        private final int uniq_id;
	private Node paraent = null;
        
	static{
		id = 0;
	}
	
	public NodeImplementation(String name , Node parent) {
		this.name = name;
                this.paraent = parent;
		id++;
                uniq_id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getId() {
		return String.valueOf(uniq_id);
	}

        @Override
        public String toString() {
            return name + " : " + String.valueOf(uniq_id);
        }

        @Override
        public Node getParent() {
            return this.paraent;
        }   
}