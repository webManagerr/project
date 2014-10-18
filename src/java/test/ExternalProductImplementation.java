package test;

import org.radixware.web.manager.DistributionKits;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.ExternalProducts;
import org.radixware.manager.entry.ProductDistributivesEntry;

public class ExternalProductImplementation extends NodeImplementation implements ExternalProduct {

    private DistributionKits distributionKits = null;
    private ProductDistributivesEntry productDistributivesEntry = null;

    public ExternalProductImplementation(ProductDistributivesEntry pde, ExternalProducts parent) {
        super(pde.getName(), parent);
        this.productDistributivesEntry = pde;
    }

    @Override
    public String getURL() {
        return productDistributivesEntry.getURL().getPath();
    }

    public ProductDistributivesEntry getProductDistributivesEntry() {
        return productDistributivesEntry;
    }

    @Override
    public DistributionKits getDistributionKits() {
        synchronized (this) {
            if (distributionKits == null) {
                distributionKits = new DistributionKitsImplementation(this);
            }
        }
        return distributionKits;
    }

    @Override
    protected String idUrl() {
        return productDistributivesEntry.getURL().getPath();
    }

    @Override
    protected String idUrlParent() {
        return productDistributivesEntry.getParent().getURL().getPath();
    }
}
