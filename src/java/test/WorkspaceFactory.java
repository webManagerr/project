package test;


import org.radixware.web.manager.Workspace;

public class WorkspaceFactory {
        
        static private Workspace workspace = null;
        static private Object monitor = new Object();
	static  public Workspace getInstance()
	{	
            synchronized(monitor)
            {
                if(workspace == null){
                    ProjectListImplementation pj = new ProjectListImplementation();
                    workspace = new WorkspaceImplementation(pj);
                }
            }
            
            return workspace;
        }
}













