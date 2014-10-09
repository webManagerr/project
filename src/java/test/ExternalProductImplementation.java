package test;


import org.radixware.web.manager.DistributionKits;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.ExternalProducts;
import org.radixware.manager.entry.ProductDistributivesEntry;



public class ExternalProductImplementation extends NodeImplementation implements ExternalProduct
{
	private DistributionKits dks = null;
        private ProductDistributivesEntry pde = null;
        
	public ExternalProductImplementation(ProductDistributivesEntry pde , ExternalProducts parent) {
		super(pde.getName(), parent);
		this.pde = pde;
	}

	@Override
	public  String getURL() {
            return pde.getURL().getPath();
	}
        
        public ProductDistributivesEntry getProductDistributivesEntry()
        {
            return pde;
        }

	@Override
	public DistributionKits getDistributionKits() {
            synchronized(this){
                if(dks == null)
                {
                    dks = new DistributionKitsImplementation(this);
                }
            }
            return dks;
	}
}