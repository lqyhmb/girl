package com.lqyhmb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Rodriguez
 * 2017/9/4 15:43
 */

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String name;

    private String cupSize;

    private Integer age;

    public GirlProperties() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
