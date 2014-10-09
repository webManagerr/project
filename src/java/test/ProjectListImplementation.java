package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.radixware.web.manager.Project;
import org.radixware.web.manager.ProjectList;
import org.radixware.kernel.common.dialogs.AuthenticationCancelledException;
import org.radixware.kernel.common.svn.SVN;
import org.radixware.manager.entry.ProjectEntry;
import org.radixware.schemas.product.ManagerProjectDocument;
import org.radixware.web.manager.NodeList;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;


public class ProjectListImplementation extends DirImplementation<Project> implements ProjectList
{
    private List<Project> projects = null;
    private final String projectsPath = "C:/Users/Denis/Desktop/project";

    public ProjectListImplementation() {
        super("project List" , null);   
    }

    @Override
    public NodeList getNodeList() {
        synchronized(this){
            if(projects == null)
            {
                projects = new ArrayList<>();
                upload();
                NodeListImplementation<Project> nlProj = new NodeListImplementation<>(projects);
                super.setNodeList(nlProj); 
            }
        }
        return super.getNodeList(); //To change body of generated methods, choose Tools | Templates.
    }

    private void upload(){
        
        File dir = new File(projectsPath);
        File[] projectDirs = dir.listFiles((File pathname) -> pathname.isDirectory());
        if (projectDirs != null) {
            for (File pd : projectDirs) {
                File projectXml = new File(pd, "project.xml");
                if (!projectXml.exists()) {
                    continue;
                }
                InputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(projectXml);
                    ManagerProjectDocument projectXmlDoc = ManagerProjectDocument.Factory.parse(inputStream);
                    final SVNRepository svn = SVN.createRepository(projectXmlDoc.getManagerProject());
                    final long svnRevision = svn.getLatestRevision();
                    final SVNDirEntry dirEntry = svn.info(new String(), svnRevision);
                    if (dirEntry == null) {
                        throw new RuntimeException("There are no SVN entry with at specified path '" + String.valueOf(projectXmlDoc.getManagerProject().getSvnHomeUrl()) + "'");
                    }
                    ProjectEntry project = new ProjectEntry(svn, svnRevision, dirEntry, pd.getAbsolutePath(), projectXmlDoc);
                    //project.getReleases().getReleasesList();
                    projects.add(new ProjectImplementation(project , this));
                    
                } catch (IOException | SVNException | XmlException | AuthenticationCancelledException e) {
                    throw new ProjectInfoAccessException(e);
                } finally{
                    try {
                        if(inputStream != null)
                            inputStream.close();
                    } catch (IOException ex) {
                        throw new ProjectInfoAccessException(ex);
                    }
                }
                
            }
        }
    }
}