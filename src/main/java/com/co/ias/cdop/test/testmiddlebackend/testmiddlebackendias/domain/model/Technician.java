package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model;

public class Technician {
    private Integer id;
    private String name;

    public Technician(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
