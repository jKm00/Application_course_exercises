package no.edvardsen.relationtest.dto;

import java.util.List;

public class AddProductRequest {
    private String title;
    private String desc;
    private float price;
    private List<String> colors;

    public AddProductRequest(String title, String desc, float price, List<String> colors) {
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.colors = colors;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public float getPrice() {
        return price;
    }

    public List<String> getColors() {
        return colors;
    }
}
