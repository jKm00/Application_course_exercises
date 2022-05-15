package no.edvardsen.relationtest.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductEntryKey implements Serializable {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "color_id")
    private Long colorId;

    public ProductEntryKey() {}

    public ProductEntryKey(Long productId, Long colorId) {
        this.productId = productId;
        this.colorId = colorId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }
}
