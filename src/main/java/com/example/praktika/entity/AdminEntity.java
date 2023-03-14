package com.example.praktika.entity;


public class AdminEntity {

    private Integer id;
    private String role;
    private String username;
    private String password;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}
    public AdminEntity() {}
    public AdminEntity(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }
}
