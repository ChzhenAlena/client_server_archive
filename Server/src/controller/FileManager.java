package controller;

import model.*;

import java.io.File;

public class FileManager {
    private File directory;
    //private File archiveFile;
    private File usersFile;
    FileManager(String directory){
        this.directory = new File(directory);
        //archiveFile = new File(directory + "students.xml");
        usersFile = new File(directory + "users.xml");
    }
    FileManager(){
        this("Server\\src\\files\\");
    }

    public Student readStudentFromFile(String id){
        File file = new File(directory, id+".xml");
        if(!file.exists())
            return null;
        Student student = XmlParser.demarshalize(file, Student.class);
        return student;
    }
    public boolean deleteStudentFile(String id){
        File file = new File(directory, id+".xml");
        if(!file.exists())
            return false;
        else{
            file.delete();
            return true;
        }
    }
    public boolean fileExists(String id){
        File file = new File(directory, id+".xml");
        if(file.exists())
            return true;
        else{
            return false;
        }
    }
    public void writeStudentToFile(Student student){
        File file = new File(directory, String.valueOf(student.getId())+".xml");
        XmlParser.marshalize(file, student, Student.class);
    }
    /*public Students readArchiveXML(){
        return XmlParser.demarshalize(archiveFile, Students.class);
    }
    public void writeArchiveXML(Students students){
        XmlParser.marshalize(archiveFile, students, Students.class);
    }
*/
    public Users readUsersXML(){
        return XmlParser.demarshalize(usersFile, Users.class);
    }
    public void writeUsersXML(Users users){
        XmlParser.marshalize(usersFile, users, Users.class);
    }
    public static void main(String[] args) {



        Student student1 = new Student(1, "SD", "23423423", 3434);
        Student student2 = new Student(2, "SDGSDFGSDF", "111", 00000);
        FileManager fileManager = new FileManager();
        fileManager.writeStudentToFile(student1);
        fileManager.writeStudentToFile(student2);



    }
}
