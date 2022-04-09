package no.edvardsen.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_entries")
public class ProductEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private String color;
    private String sizeValue;
    private int quantity;

    public ProductEntry() {}

    public ProductEntry(int productId, String color, String sizeValue, int quantity) {
        this.productId = productId;
        this.color = color;
        this.sizeValue = sizeValue;
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

    public String getColor() {
        return color;
    }

    public void setColor(String colorId) {
        this.color = colorId;
    }

    public String getSizeValue() {
        return sizeValue;
    }

    public void setSizeId(String sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
