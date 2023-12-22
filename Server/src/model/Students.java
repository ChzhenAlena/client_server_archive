package model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@XmlType(name = "students")
@XmlRootElement
public class Students {
    @XmlElement(name = "student")
    public List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }
    public void printStudents(){
        for(Student student : students)
            System.out.println(student.toString());
    }
}
