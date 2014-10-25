package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Layer;
import org.radixware.manager.entry.ScriptsLayerEntry;
import org.tmatesoft.svn.core.SVNException;

public class ScriptLayerImplementation implements Layer {

    ScriptsLayerEntry sle;

    public ScriptLayerImplementation(ScriptsLayerEntry sle) {
        this.sle = sle;
    }

    @Override
    public String getURL() {
        return this.sle.getURL().getPath();
    }

    @Override
    public String getURI() {
        return this.sle.getUri();
    }

    @Override
    public String getName() {
        return this.sle.getName();
    }

    //TODO : без понятия 
    @Override
    public String getVersion() {
        try {
            return this.sle.getReleaseNumbers().toString();
        } catch (XmlException | IOException | SVNException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }
}
