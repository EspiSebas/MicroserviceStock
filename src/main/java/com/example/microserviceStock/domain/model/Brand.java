package com.example.microserviceStock.domain.model;

import com.example.microserviceStock.domain.constants.Rules;
import com.example.microserviceStock.domain.exception.DescriptionException;
import com.example.microserviceStock.domain.exception.NameException;

public class Brand {
    private String name;
    private String description;

    public Brand(String name, String description) {
        if(name.length() > Rules.MaxNameBrandLength){
            throw new NameException("The name is too long");
        }

        if(description.length() > Rules.MaxDescriptionBrandLength){
            throw new DescriptionException("The description is too long");
        }

        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
