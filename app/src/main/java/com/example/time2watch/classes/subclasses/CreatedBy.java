package com.example.time2watch.classes.subclasses;

public class CreatedBy {
    private String id;
    private String credit_id;
    private String name;
    private String gender;

    public CreatedBy(String id, String credit_id, String name, String gender) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CreatedBy{" +
                "id='" + id + '\'' +
                ", credit_id='" + credit_id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
