package com.lintrip.java8.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 雇员信息
 */
public class Employee implements  Cloneable{
    private String name;
    private Integer age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Integer age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .append("salary", salary)
                .toString();
    }
}
