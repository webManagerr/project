package test;

import java.util.List;
import org.radixware.web.manager.DistributionKit;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;
import org.radixware.web.manager.ProjectList;
import org.radixware.web.manager.Workspace;

public class WorkspaceImplementation implements Workspace
{
	private final ProjectListImplementation pj;
	
	public WorkspaceImplementation(ProjectListImplementation projList) {
		this.pj = projList;
	}
	
	@Override
	public Node findNodeById(String id) {
            
                Node result = null;
                
                if(id == null)
                {
                    throw new IllegalArgumentException("Id is null");
                }
                
                for(Project p : (List<Project>)pj.getNodeList().getNodes())
                {
                    if(id.equals(p.getId()))
                    {
                        result = p;
                        return result;
                    }
                    
                    if(id.equals(p.getExternalProducts().getId()))
                    {
                        result = p.getExternalProducts();
                        return result;
                    }
                    
                    for(ExternalProduct ex :  p.getExternalProducts())
                    {
                        if(id.equals(ex.getId()))
                        {
                            result = ex;
                            return result;
                        }
                        
                        if(id.equals(ex.getDistributionKits().getId()))
                        {
                            result = ex.getDistributionKits();
                            return result;
                        }
                        
                        for(DistributionKit dk :  ex.getDistributionKits())
                        {
                            if(id.equals(dk.getId()))
                            {
                                result = dk;
                                return result;
                            }
                            
                            if(id.equals(dk.getRelease().getId()))
                            {
                                result = dk.getRelease();
                                return result;
                            }
                            
                            if(id.equals(dk.getScripts().getId()))
                            {
                                result = dk.getScripts();
                                return result;
                            }
                        }
                    }
                }
            
		return result;
	}

	@Override
	public ProjectList getProjectList() {
		return pj;
	}	
}