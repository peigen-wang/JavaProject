package com.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "classify", schema = "camielbackage")
public class ClassifyEntity {
    private int id;
    private String title;
    private int types;
    private int sort;
    private String iconUrl;
    private String iconClickUrl;
    private Timestamp createTime;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Types")
    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    @Basic
    @Column(name = "Sort")
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "IconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Basic
    @Column(name = "IconClickUrl")
    public String getIconClickUrl() {
        return iconClickUrl;
    }

    public void setIconClickUrl(String iconClickUrl) {
        this.iconClickUrl = iconClickUrl;
    }

    @Basic
    @Column(name = "CreateTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassifyEntity that = (ClassifyEntity) o;
        return id == that.id &&
                types == that.types &&
                sort == that.sort &&
                Objects.equals(title, that.title) &&
                Objects.equals(iconUrl, that.iconUrl) &&
                Objects.equals(iconClickUrl, that.iconClickUrl) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, types, sort, iconUrl, iconClickUrl, createTime);
    }
}
