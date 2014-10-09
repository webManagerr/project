package test;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Release;
import org.radixware.manager.entry.DistributiveReleaseEntry;
import org.tmatesoft.svn.core.SVNException;

public class ReleaseImplementation extends NodeImplementation implements Release
{

        private DistributiveReleaseEntry dre;
    
	public ReleaseImplementation(DistributiveReleaseEntry dre , NodeImplementation parent) {
		super(dre.getDisplayName(),parent);
                this.dre = dre;
	}

	@Override
	public String getVersion() {
		return dre.getName();
	}

	@Override
	public String getPrevReleaseVersion() {
            String vers = "";
            try {
                
                for(Integer i : dre.getPrevReleaseNumber())
                {
                    vers += String.valueOf(i)+"\n";
                }
                
            } catch (    IOException | XmlException | SVNException ex) {
                throw new ProjectInfoAccessException(ex);
            }
            
            return vers;
	}

	@Override
	public String getStatus() {
            try {
                return dre.findReleaseStatus().getName();
            } catch (    IOException | XmlException | SVNException ex) {
                throw new ProjectInfoAccessException(ex);
            }
	}
	
}