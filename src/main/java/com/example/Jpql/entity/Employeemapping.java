package com.example.Jpql.entity;

import javax.persistence.*;

@Entity
@Table(name = "employeetab")
public class Employeemapping {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Embedded
    private Salarymapping salarymapping;

    public int getId() {
        return id;
    }
    public Salarymapping getSalarymapping() {
        return salarymapping;
    }

    public void setSalarymapping(Salarymapping salarymapping) {
        this.salarymapping = salarymapping;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
