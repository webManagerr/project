package test;


import org.radixware.web.manager.Workspace;

public class WorkspaceFactory {
        
        static private Workspace workspace = null;
	static  public Workspace getInstance()
	{	
            synchronized(workspace)
            {
                if(workspace == null){
                    ProjectListImplementation pj = new ProjectListImplementation();
                    workspace = new WorkspaceImplementation(pj);
                }
            }
            
            return workspace;
        }
}













