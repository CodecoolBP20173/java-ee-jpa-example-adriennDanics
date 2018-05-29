package com.codecool.jpaexample.model;

import org.apache.logging.log4j.core.tools.Generate;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Class")
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "klass", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private CCLocation location;

    public Klass() {}

    public Klass(String name, CCLocation location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public CCLocation getLocation() {
        return location;
    }

    public void setLocation(CCLocation location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setClass(this);
        students.add(student);
    }

}
