package model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name = "login")
    public String login;
    @XmlElement(name = "password")
    public String password;
   // @XmlElement(name = "accessType", required = true)
    //public AccessType accessType;
    public User(){}
   /* public User(String login, String password, AccessType accessType){
        this.login = login;
        this.password = password;
        this.accessType = accessType;

    }*/
    public User(String login, String password){
        this.login = login;
        this.password = password;
        //this.accessType = AccessType.READ;

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }*/
}
