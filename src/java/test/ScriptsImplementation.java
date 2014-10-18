package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Layer;
import org.radixware.web.manager.Layers;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Scripts;
import org.radixware.manager.entry.DistributiveScriptsEntry;
import org.radixware.manager.entry.ScriptsLayerEntry;
import org.tmatesoft.svn.core.SVNException;

public class ScriptsImplementation extends NodeImplementation implements Scripts
{
	DistributiveScriptsEntry distributiveScriptsEntry;
        List<Layer> layers = null;
	public ScriptsImplementation(DistributiveScriptsEntry dse , Node parent) {
            super(dse.getDisplayName(),parent);
            this.distributiveScriptsEntry = dse;
            
	}
	
	@Override
	public Layers getLayers() {
            try {
                synchronized(this){
                    if
                        (layers == null){
                        layers = new ArrayList<>();
                        for(ScriptsLayerEntry element : distributiveScriptsEntry.getLayers())
                        {
                            layers.add(new LayerImplementation(element));
                        }
                    }
                }
                return new ScriptLayersImplementation(layers);
                
            } catch (    XmlException | IOException | SVNException ex) {
                throw new ProjectInfoAccessException(ex);
            }
	}	

    @Override
    protected String idUrl() {
        return distributiveScriptsEntry.getURL().getPath();
    }

    @Override
    protected String idUrlParent() {
        return distributiveScriptsEntry.getParent().getURL().getPath();
    }
}