package test;

import org.radixware.web.manager.Layer;
import org.radixware.manager.entry.ScriptsLayerEntry;

public class LayerImplementation implements Layer
{
	ScriptsLayerEntry sle;
	
	public LayerImplementation(ScriptsLayerEntry sle) {
		this.sle = sle;
	}

	@Override
	public String getURL() {
		return this.sle.getUri();
	}
}