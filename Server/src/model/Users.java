package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
@XmlType(name = "users")
@XmlRootElement
public class Users {
    @XmlElement(name = "user")
    public List<User> users = new ArrayList<>();
    public void addUser(User user){
        users.add(user);
    }
    public void printStudents(){
        for(User user : users)
            System.out.println(user.toString());
    }
}
