package model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {
    public int id;
    public String name = "unknown";
    public String birthDate = "unknown";
    public int groupNumber;
    public Student(){}
    public Student(int id, String name, String birthDate, int groupNumber){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.groupNumber = groupNumber;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
}
