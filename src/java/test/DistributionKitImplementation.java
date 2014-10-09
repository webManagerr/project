package test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.DistributionKit;
import org.radixware.web.manager.DistributionKits;
import org.radixware.web.manager.Release;
import org.radixware.web.manager.Scripts;
import org.radixware.manager.entry.DistributiveEntry;
import org.radixware.manager.entry.UpgradeXmlEntry;
import org.radixware.schemas.product.StructuredChanges;
import org.radixware.schemas.product.Upgrade;
import org.radixware.schemas.product.UpgradeDocument;
import org.tmatesoft.svn.core.SVNException;

public class DistributionKitImplementation extends NodeImplementation implements DistributionKit {

    private DistributiveEntry de = null;
    private Timestamp time = null;
    private String changeList = null;
    private ReleaseImplementation release = null;
    private ScriptsImplementation scripts = null;

    public DistributionKitImplementation(DistributiveEntry de, DistributionKits parent) {
        super(de.getName(), parent);
        this.de = de;
    }

    Upgrade getUpXml() throws ProjectInfoAccessException {
        try {
            UpgradeXmlEntry e = de.getUpgradeXml();
            UpgradeDocument xDoc = e.getDocument();
            return xDoc.getUpgrade();
        } catch (SVNException ex) {
            throw new ProjectInfoAccessException(ex);
        } catch (XmlException ex) {
            throw new ProjectInfoAccessException(ex);
        } catch (IOException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }

    @Override
    public String getVersion() {
        return de.getShortIdentifer();
    }

    @Override
    public Timestamp getCreateTime() {
        synchronized(this){
            if(time == null)
            {
                time = new Timestamp(getUpXml().getTime());
            }
        }
        return time;
    }

    @Override
    public String getDescription() {
        return getUpXml().getDescription();
    }

    @Override
    public String getChangeList() {
        synchronized(this){
            if(changeList == null)
                for(StructuredChanges ch : getUpXml().getStructuredChangesList())
                {
                    changeList += ch.xmlText();
                }
        }
        return changeList;
    }

    @Override
    public String getPrevVersion() {
        return getUpXml().getPrevReleaseNumber();
    }

    @Override
    public Release getRelease() {
        synchronized(this){
            if(release == null)
                try {
                        release = new ReleaseImplementation(de.getRelease(), this);
                } catch (SVNException ex) {
                    Logger.getLogger(DistributionKitImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return release;
    }

    @Override
    public Scripts getScripts() {
        synchronized(this){
            if(scripts == null)
                try {
                    scripts = new ScriptsImplementation(de.getScripts(), this);
                } catch (SVNException ex) {
                    Logger.getLogger(DistributionKitImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return scripts;
    }
}
