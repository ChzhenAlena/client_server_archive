package controller;

import model.*;

import java.io.File;

public class FileManager {
    private File directory;
    private File archiveFile;
    private File usersFile;
    FileManager(String directory){
        this.directory = new File(directory);
        archiveFile = new File(directory + "files\\students.xml");
        usersFile = new File(directory + "files\\users.xml");
    }
    FileManager(){
        this("Server\\src\\");
    }

    public void findStudentFile(int id){

    }
    public Students readArchiveXML(){
        return XmlParser.demarshalize(archiveFile, Students.class);
    }
    public void writeArchiveXML(Students students){
        XmlParser.marshalize(archiveFile, students, Students.class);
    }

    public Users readUsersXML(){
        return XmlParser.demarshalize(usersFile, Users.class);
    }
    public void writeUsersXML(Users users){
        XmlParser.marshalize(usersFile, users, Users.class);
    }
    public static void main(String[] args) {
        Users users = new Users();
        User user1 = new User("sdf", "wef", AccessType.EDIT);
        User user2 = new User("sdf", "wef", AccessType.EDIT);
        users.addUser(user1);
        users.addUser(user2);

        Students students = new Students();
        Student student1 = new Student("SD", "23423423", 3434);
        Student student2 = new Student("SDGSDFGSDF", "111", 00000);
        students.addStudent(student1);
        students.addStudent(student2);

        FileManager fileManager = new FileManager();
        System.out.println("students");
        fileManager.writeArchiveXML(students);
        Students students1 = fileManager.readArchiveXML();
        students1.printStudents();

        System.out.println("users");
        fileManager.writeUsersXML(users);
        Users users1 = fileManager.readUsersXML();
        users1.printUsers();
    }
}
