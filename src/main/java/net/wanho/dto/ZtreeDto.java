package net.wanho.dto;

import lombok.Data;

/**
 * Created by DELL on 2019/4/27.
 */


public class ZtreeDto {

    private Integer id;
    private Integer pId;
    private String name;

    public ZtreeDto() {

    }

    public ZtreeDto(Integer id, Integer pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZtreeDto{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                '}';
    }
}
