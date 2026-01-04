package com.example.microserviceStock.domain.model;

import com.example.microserviceStock.domain.constants.Rules;
import com.example.microserviceStock.domain.exception.DescriptionException;
import com.example.microserviceStock.domain.exception.NameException;

public class Category {

    public Category(String name, String description) {

        if(name.length() > Rules.MaxNameCategoryLength){
            throw new NameException("The name is too long");
        }

        if(description.length() > Rules.MaxDescriptionCategoryLength){
           throw  new DescriptionException("The description is too long");
        }

        this.name = name;
        this.description = description;
    }


    private String name;
    private String description;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
