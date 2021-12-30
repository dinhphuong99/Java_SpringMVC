package com.codegym.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class User {

    @Size(min = 2, max = 30, message = "Size 2 to 30")
    private String name;

    @Min(18)
    @Max(90)
    @NumberFormat
    private int age;

    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}