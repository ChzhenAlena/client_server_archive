package controller;

import jakarta.xml.bind.*;

import java.io.File;

public class XmlParser {

    /*public static void marshalize(File file, Students students){
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(model.Students.class);
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
    }*/

    public static <T> void marshalize(File file, T objects, Class clss){
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(clss);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objects, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T demarshalize(File file, Class clss){
        T objects;
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        try {
            context = JAXBContext.newInstance(clss);
            unmarshaller = context.createUnmarshaller();
            objects = (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }


}
