package com.example.passactivity;

public class Person {
    private String Name;
    private String Surname;
    private String Status;
    private String Login;
    private String Password;
    private int Age;
    private String Grade;

    public Person() {
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getStatus() {
        return Status;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public int getAge() {
        return Age;
    }

    public String getGrade() {
        return Grade;
    }
}
