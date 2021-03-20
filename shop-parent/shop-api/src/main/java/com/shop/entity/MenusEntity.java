package com.shop.entity;

public class MenusEntity {
    private int id;
    private String name;
    private int parentid;
    private String path;
    private int sorts;
    private String module;
    private int isback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSorts() {
        return sorts;
    }

    public void setSorts(int sorts) {
        this.sorts = sorts;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getIsback() {
        return isback;
    }

    public void setIsback(int isback) {
        this.isback = isback;
    }
}
