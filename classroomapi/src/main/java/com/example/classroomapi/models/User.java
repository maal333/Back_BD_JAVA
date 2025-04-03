package com.example.classroomapi.models;

import com.example.classroomapi.help_package.Type_user;
import jakarta.persistence.*;

@Entity
@Table (name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Integer user_id;

    @Column(name = "nombre",nullable = false,length = 100)
    private String username;

    @Column(name = "contraseña",length = 260, nullable = false)
    private String password;

    @Column(name = "correo_electronico",length = 150, nullable = false,unique = false)
    private String email;

    @Column(name = "celular",length = 20,nullable = true,unique = false)
    private String phone;
    @Column(name = "tipo_usuario",nullable = false )
    private Type_user type_user;


    public User() {
    }

    public User(Integer user_id, String username, String password, String email, String phone, Type_user type_user) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.type_user = type_user;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type_user getType_user() {
        return type_user;
    }

    public void setType_user(Type_user type_user) {
        this.type_user = type_user;
    }
}