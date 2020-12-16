package com.lintrip.java8.domain;

import java.util.Date;

/**
 * 学生实体类
 */
// @JsonIgnoreProperties(value = {"name","region"}) 过滤一个类中的多个对象
public class Student {
    private int id;
    private String name;
    private Integer age;
    private String region = "cn";
    private String address;
    private Date birthDay;

    public Student(){}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // @JsonIgnore 忽略单一属性，在 get 方法上标注
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
