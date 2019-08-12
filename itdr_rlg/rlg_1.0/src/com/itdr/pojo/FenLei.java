package com.itdr.pojo;

public class FenLei {
    private Integer id;
    private String parentId;
    private String name;
    private String status;
    private String sortorder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    @Override
    public String toString() {
        return "FenLei{" +
                "id=" + id +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sortorder='" + sortorder + '\'' +
                '}';
    }
}
