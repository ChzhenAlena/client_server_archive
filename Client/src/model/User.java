package model;

public class User {
    private String login;
    private String password;

    private AccessType accessType;
    public User(){}
    public User(String login, String password, AccessType accessType){
        this.login = login;
        this.password = password;
        this.accessType = accessType;

    }
    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.accessType = AccessType.READING;

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

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }
}
