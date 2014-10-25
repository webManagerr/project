package test;

import org.radixware.web.manager.Layer;
import org.radixware.manager.entry.ScriptsLayerEntry;

public class ScriptLayerImplementation implements Layer {

    ScriptsLayerEntry sle;

    public ScriptLayerImplementation(ScriptsLayerEntry sle) {
        this.sle = sle;
    }

    @Override
    public String getURL() {
        return this.sle.getUri();
    }
}
