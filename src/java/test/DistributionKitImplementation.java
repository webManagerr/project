package test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
import org.radixware.schemas.product.StructuredChanges.StructuredChange;
import org.radixware.schemas.product.Upgrade;
import org.radixware.schemas.product.UpgradeDocument;
import org.tmatesoft.svn.core.SVNException;

public class DistributionKitImplementation extends NodeImplementation implements DistributionKit {

    private DistributiveEntry de = null;
    private Timestamp time = null;
    private List<String> changeList = null;
    private ReleaseImplementation release = null;
    private ScriptsImplementation scripts = null;
    private String version;
    private String description;
    private String pervVersion;

    public DistributionKitImplementation(DistributiveEntry de, DistributionKits parent) {
        super(de.getName(), parent);
        this.de = de;
    }

    private void intitMembers()
    {
       synchronized(this){
            version = de.getShortIdentifer();
            time = new Timestamp(getUpXml().getTime());
            description = getUpXml().getDescription();
            if (changeList == null) {
                   changeList = new ArrayList<>();
                   for (StructuredChanges ch : getUpXml().getStructuredChangesList()) {
                       for (StructuredChange element : ch.getStructuredChangeList()) {
                           changeList.add("[" + element.getIssueType() + "] ()" + element.getMessage());
                       }
                   }
               }
            pervVersion = getUpXml().getPrevReleaseNumber();
           try {
               release = new ReleaseImplementation(de.getRelease(), this);
               scripts = new ScriptsImplementation(de.getScripts(), this);
           } catch (SVNException ex) {
              throw new ProjectInfoAccessException(ex);
           }
       }
    }
    
    Upgrade getUpXml() throws ProjectInfoAccessException {
        try {
            UpgradeXmlEntry e = de.getUpgradeXml();
            UpgradeDocument xDoc = e.getDocument();
            return xDoc.getUpgrade();
        } catch (SVNException | XmlException | IOException ex) {
            throw new ProjectInfoAccessException(ex);
        }
    }

    @Override
    public String getVersion() {
        if(version == null)
        {
            intitMembers();
        }
        return version;
    }

    @Override
    public Timestamp getCreateTime() {
        if(version == null)
        {
            intitMembers();
        }
        return time;
    }

    @Override
    public String getDescription() {
        if(version == null)
        {
            intitMembers();
        }
        return description;
    }

    @Override
    public List<String> getChangeList() {
        if(version == null)
        {
            intitMembers();
        }
        return changeList;
    }

    @Override
    public String getPrevVersion() {
        if(version == null)
        {
            intitMembers();
        }
        return this.pervVersion;
    }

    @Override
    public Release getRelease() {
        if(version == null)
        {
            intitMembers();
        }
        return release;
    }

    @Override
    public Scripts getScripts() {
        if(version == null)
        {
            intitMembers();
        }
        return scripts;
    }

    @Override
    protected String idUrl() {
       return de.getURL().getPath();
    }

    @Override
    protected String idUrlParent() {
        return de.getParent().getURL().getPath();
    }
}
