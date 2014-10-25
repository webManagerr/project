/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Iterator;
import java.util.List;
import org.radixware.manager.entry.BaseEntry;
import org.radixware.manager.entry.LayerEntry;
import org.radixware.web.manager.Layer;
import org.radixware.web.manager.Layers;

/**
 *
 * @author Денис
 */
public class BranchLayersImplementation implements Layers{
    private List<Layer> layers;

    public BranchLayersImplementation(List<Layer> branchEntry) {
        this.layers = branchEntry;
    }

    @Override
    public Iterator<Layer> iterator() {
       return layers.iterator(); 
    }
    
}
