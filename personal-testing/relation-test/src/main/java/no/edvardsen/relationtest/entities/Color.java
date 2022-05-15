package no.edvardsen.relationtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "color")
    private Set<ProductEntry> productEntries = new LinkedHashSet<>();

    public Color() {}

    public Color(String color) {
        this.color = color;
    }

    /**
     * Adds a product entry to the color
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<ProductEntry> getProductEntries() {
        return productEntries;
    }

    public void setProductEntries(Set<ProductEntry> productEntries) {
        this.productEntries = productEntries;
    }
}
