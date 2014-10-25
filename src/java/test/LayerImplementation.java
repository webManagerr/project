/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.radixware.manager.entry.LayerEntry;
import org.radixware.manager.entry.ScriptsLayerEntry;
import org.radixware.web.manager.Layer;

/**
 *
 * @author Денис
 */
public class LayerImplementation  implements Layer{
    
    LayerEntry layerEntry;

    public LayerImplementation(LayerEntry layerEntry) {
        this.layerEntry = layerEntry;
    }

    @Override
    public String getURL() {
        return this.layerEntry.getUri();
    }
}
