package dto;

import java.time.LocalDateTime;
import attoEnum.enumProfile;
import attoEnum.enumRole;

public class dtoProfile {

    private int id;
    private String  name;
    private String surname;
    private String phone;
    private String password;
    private String login;
    private LocalDateTime created_date;
    private enumProfile status;
    private enumRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public enumProfile getStatus() {
        return status;
    }

    public void setStatus(enumProfile status) {
        this.status = status;
    }

    public enumRole getRole() {
        return role;
    }

    public void setRole(enumRole role) {
        this.role = role;
    }
}
