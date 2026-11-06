package com.pronchenko.labs;

import java.util.Objects;

public class Entity {

    // параметтры сущностей
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String origin;
    private String location;
    private String created;

    // конструктор по умолчанию
    public Entity() {}

    // конструтор
    public Entity(Integer id, String name, String status, String species, String type, String gender, String origin, String location, String created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.created = created;
    }

    // гетеры
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLocation() {
        return location;
    }

    public String getCreated() {
        return created;
    }


    // сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    // перегрузка оператора
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Entity) obj;
        return this.id.equals(that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.status, that.status) &&
                Objects.equals(this.species, that.species) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.origin, that.origin) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.created, that.created);
    }

}
