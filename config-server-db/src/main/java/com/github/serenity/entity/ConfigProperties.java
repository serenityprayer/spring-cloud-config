package com.github.serenity.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table
public class ConfigProperties {

    @Id
    @GeneratedValue
    private Long propertiesKey;

    private String propertiesName;

    @Lob
    @Column
    @Type(type = "com.github.serenity.base.CustomizedJsonType")
    private String content;

    public Long getPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(Long propertiesKey) {
        this.propertiesKey = propertiesKey;
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
