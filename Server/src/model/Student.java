package model;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement

public class Student implements Serializable {
    @XmlElement(name = "id")
    public int id;
    @XmlElement(name = "name")
    public String name = "unknown";
    @XmlElement(name = "birthDate")
    public String birthDate = "unknown";
    @XmlElement(name = "groupNumber")
    public int groupNumber = 0;
    public Student(){}
    public Student(int id, String name, String birthDate, int groupNumber){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
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
