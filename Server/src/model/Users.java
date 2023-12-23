package model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "users")
@XmlRootElement
public class Users {
    @XmlElement(name = "user")
    public List<User> users = new ArrayList<>();


    public void addUser(User user){
        users.add(user);
    }
    public void printUsers(){
        for(User user : users)
            System.out.println(user.toString());
    }
}
