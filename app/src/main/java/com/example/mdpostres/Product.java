package com.example.mdpostres;

import java.util.Objects;

public class Product {
    private String name;
    private String url;
    private boolean selected;

    public Product(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product p = (Product) obj;

        if (selected != p.selected) return false;
        // if (name != null ? !name.equals(p.name) : p.name != null) return false;
        // return url != null ? url.equals(p.url) : p.url == null;
        if (!Objects.equals(name, p.name)) return false;
        return Objects.equals(url, p.url);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31* result + (url != null ? url.hashCode() : 0);
        result = 31* result + (selected ? 1 : 0);
        return result;
    }
}
