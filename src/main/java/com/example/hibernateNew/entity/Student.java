package com.example.hibernateNew.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

@Entity
//defining class name as Table name
@Table(name = "student")
@Cacheable
public class Student
{
    //mark id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//defining id as column name
    @Column
    private int id;
    //defining name as column name
    @Column
    private String name;
    //defining age as column name
    @Column
    private int age;
    //defining email as column name
    @Column
    private String email;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public  Student(String name, Integer age, String emailId){
        this.name=name;
        this.age=age;
        this.email=emailId;
    }

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void Destroy(){

    }
}