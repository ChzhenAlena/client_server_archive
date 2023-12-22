package model;

import jakarta.xml.bind.annotation.*;

public class Student {
    @XmlElement(name = "name")
    public String name = "unknown";
    @XmlElement(name = "birthDate")
    public String birthDate = "unknown";
    @XmlElement(name = "groupNumber")
    public int groupNumber = 0;

    public Student(){

    };
    public Student(String name, String birthDate, int groupNumber){
        this.name = name;
        this.birthDate = birthDate;
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }

   /* public String getName() {
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
    }*/

}
