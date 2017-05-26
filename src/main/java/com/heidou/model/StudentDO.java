package com.heidou.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @author: heidou
 * @description:
 * @data2017/5/26.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDO implements Serializable{
    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
