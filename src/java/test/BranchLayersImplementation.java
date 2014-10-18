/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Iterator;
import org.radixware.manager.entry.BaseEntry;
import org.radixware.web.manager.Layer;
import org.radixware.web.manager.Layers;

/**
 *
 * @author Денис
 */
public class BranchLayersImplementation implements Layers{
    private BaseEntry branchEntry;

    public BranchLayersImplementation(BaseEntry branchEntry) {
        this.branchEntry = branchEntry;
    }

    @Override
    public Iterator<Layer> iterator() {
       return null; //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
