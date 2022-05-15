package no.edvardsen.relationtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String desc;
    @Column(name = "price")
    private float price;

    @OneToMany(mappedBy = "product")
    private Set<ProductEntry> productEntries = new LinkedHashSet<>();

    public Product() {}

    public Product(String title, String desc, float price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    /**
     * Adds a product entry to the product
     * @param productEntry to be added
     */
    public void addProductEntry(ProductEntry productEntry) {
        this.productEntries.add(productEntry);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<ProductEntry> getProductEntries() {
        return productEntries;
    }

    public void setProductEntries(Set<ProductEntry> productEntries) {
        this.productEntries = productEntries;
    }
}
