package test;

import org.radixware.web.manager.ExternalProducts;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;
import org.radixware.manager.entry.ProjectEntry;


public class ProjectImplementation extends NodeImplementation implements Project{

	private ExternalProducts ep = null;
        private ProjectEntry pe = null;
	
	public ProjectImplementation(ProjectEntry pe , Node parent) {
            super(pe.getDisplayName(),parent);
            this.pe = pe;
	}

	@Override
	public ExternalProducts getExternalProducts() {
            synchronized(this){
                if(this.ep == null)
                {
                    this.ep = new ExternalProductsImplementation(this);
                }
            }
                return this.ep;
	}
        
        public ProjectEntry getProjectEntry() {
            return this.pe;
        } 

}