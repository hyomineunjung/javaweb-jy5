package com.itdr.pojo;

public class Product {
    private Integer id;
    private String pname;
    private Integer status;
    private Integer categoryId;
    private String price;
    private String cuxiao;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCuxiao() {
        return cuxiao;
    }

    public void setCuxiao(String cuxiao) {
        this.cuxiao = cuxiao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", status=" + status +
                ", categoryId=" + categoryId +
                ", price='" + price + '\'' +
                ", cuxiao='" + cuxiao + '\'' +
                '}';
    }
}
