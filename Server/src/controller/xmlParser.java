package controller;

import jakarta.xml.bind.*;
import model.Student;
import model.Students;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class xmlParser {

    public static void marshalize(File file, Students students){
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(model.Student.class, model.Students.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(students, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static Students demarshalize(File file){
        Students students;
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        try {
            context = JAXBContext.newInstance(Students.class);
            unmarshaller = context.createUnmarshaller();
            students = (Students) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
