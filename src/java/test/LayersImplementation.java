package test;

import java.util.Iterator;
import java.util.List;
import org.radixware.web.manager.Layer;
import org.radixware.web.manager.Layers;

public class LayersImplementation implements Layers
{
	List<Layer> layers;
	
	
	
	public LayersImplementation(List<Layer> layers) {
		this.layers = layers;
	}



	@Override
	public Iterator<Layer> iterator() {
		return layers.iterator();
	}	
}