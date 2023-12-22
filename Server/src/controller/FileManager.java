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

}
