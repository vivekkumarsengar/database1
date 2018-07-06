package com.example.vivekkumarsengar.database1;

public class STUDENTINFO {
    String Name,Email,Password,Phone;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public STUDENTINFO(){

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    public STUDENTINFO(String Name,String Password,String Email,String Phone)
    {
        this.Name=Name;
        this.Password=Password;
        this.Email=Email;
        this.Phone=Phone;

    }




}
