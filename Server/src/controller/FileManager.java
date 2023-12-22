package controller;

import model.Student;
import model.Students;

import java.io.File;

public class FileManager {
    private File directory;
    private File file;
    FileManager(String directory){
        this.directory = new File(directory);
        file = new File(directory + "students.xml");
    }
    FileManager(){
        this("Server\\src\\");
    }
    public Students readXML(){
        return xmlParser.demarshalize(file);
    }
    public void writeXML(Students students){
        xmlParser.marshalize(file, students);
    }

    public static void main(String[] args) {
        Student s = new Student();
        Student s1 = new Student("Kirill", "01.01.2001", 6363);
        Student s2 = new Student();
        Students students = new Students();
        students.addStudent(s);
        students.addStudent(s1);
        students.addStudent(s2);

        FileManager fileManager = new FileManager();
        fileManager.writeXML(students);

        Students students1 = fileManager.readXML();
        students1.printStudents();
    }
}
