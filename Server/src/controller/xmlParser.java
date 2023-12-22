package controller;

import jakarta.xml.bind.*;
import model.Student;
import model.Students;

import java.io.StringReader;
import java.io.StringWriter;

public class xmlParser {


    public static String marshalize(Students students){
        StringWriter writer = new StringWriter();

        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(model.Student.class, model.Students.class);
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(students, writer);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        //преобразовываем все записанное в StringWriter в строку
        return writer.toString();
    }

    public static Students demarshalize(String xmlData){
        Students students = new Students();
        StringReader reader = new StringReader(xmlData);
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        try {
            context = JAXBContext.newInstance(Students.class);
            unmarshaller = context.createUnmarshaller();
            students = (Students) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public static void main(String[] args) {
        Student s = new Student("Kirill", "01.01.2001", 6363);
        Student s2 = new Student();
        Students students = new Students();
        students.addStudent(s);
        students.addStudent(s2);
        String xml = marshalize(students);
        System.out.println(xml);
        Students students2 = demarshalize(xml);
        students2.printStudents();
    }
}
