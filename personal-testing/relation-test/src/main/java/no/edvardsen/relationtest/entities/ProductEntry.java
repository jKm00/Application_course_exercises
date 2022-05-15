package no.edvardsen.relationtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.edvardsen.relationtest.keys.ProductEntryKey;

import javax.persistence.*;

@Entity
@Table(name = "product_entry")
public class ProductEntry {
    @EmbeddedId
    private ProductEntryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    @JsonIgnore
    private Color color;

    private int quantity;

    public ProductEntry() {}

    public ProductEntry(ProductEntryKey id, Product product, Color color, int quantity) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.quantity = quantity;
    }

    public ProductEntryKey getId() {
        return id;
    }

    public void setId(ProductEntryKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
