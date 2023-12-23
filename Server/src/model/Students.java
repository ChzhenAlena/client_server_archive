package model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@XmlType(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Students {
    @XmlElement(name = "student")
    private List<Student> students = new ArrayList<>();


    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void printStudents(){
        for(Student student : students)
            System.out.println(student.toString());
    }
}
