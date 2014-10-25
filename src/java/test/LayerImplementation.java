/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.radixware.manager.entry.LayerEntry;
import org.radixware.manager.entry.ScriptsLayerEntry;
import org.radixware.web.manager.Layer;
import org.tmatesoft.svn.core.SVNException;

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
        return this.layerEntry.getURL().getPath();
    }

    @Override
    public String getURI() {
        return this.layerEntry.getUri();
    }

    @Override
    public String getName() {
        return this.layerEntry.getDisplayName();
    }

    @Override
    public String getVersion() {
        try {
            return this.layerEntry.getLayerXml().getXml().getReleaseNumber();
        } catch (SVNException | XmlException | IOException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }
}
