package test;


import java.util.ArrayList;
import java.util.List;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.NodeList;

public class NodeListImplementation<T extends Node> implements NodeList<T>{

	private final List<T> nodes;
	
	public NodeListImplementation(List<T> list) {
		this.nodes = list;
	}
	
	@Override
	public List<T> getNodes() {
		List<T> temp = new ArrayList<>();
                for(T element : nodes)
                {
                    temp.add(element);
                }
		return temp;
	}
}