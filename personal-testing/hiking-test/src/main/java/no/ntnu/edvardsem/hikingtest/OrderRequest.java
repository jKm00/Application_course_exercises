package no.ntnu.edvardsem.hikingtest;

import java.util.List;

public class OrderRequest {
    private final int customerId;
    private final List<Integer> productIds;

    public OrderRequest(int customerId, List<Integer> productIds) {
        this.customerId = customerId;
        this.productIds = productIds;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}
