package no.edvardsen.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_entries")
public class ProductEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int colorId;
    private int sizeId;
    private int quantity;

    public ProductEntry() {}

    public ProductEntry(int productId, int colorId, int sizeId, int quantity) {
        this.productId = productId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
