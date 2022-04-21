package no.edvardsen.backend.requests;

public class AddProductRequest {
    private String name;
    private String desc;
    private String sex;
    private int featured;
    private float price;
    private String colors;
    private String sizes;

    public AddProductRequest(String name, String desc, String sex, int featured, float price, String color_values, String size_values) {
        this.name = name;
        this.desc = desc;
        this.sex = sex;
        this.featured = featured;
        this.price = price;
        this.colors = color_values;
        this.sizes = size_values;
    }

    public boolean isValid() {
        return this.name != null && this.desc != null && this.sex != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor_values() {
        return colors;
    }

    public void setColor_values(String color_values) {
        this.colors = color_values;
    }

    public String getSize_values() {
        return sizes;
    }

    public void setSize_values(String size_values) {
        this.sizes = size_values;
    }
}
