package test;

import org.radixware.web.manager.LayerListProvider;
import org.radixware.web.manager.Layers;

public class LayerListProviderImplementation implements LayerListProvider {

    private Layers layers;

    public LayerListProviderImplementation(Layers layers) {
        this.layers = layers;
    }

    @Override
    public Layers getLayers() {
        return this.layers;
    }
}
