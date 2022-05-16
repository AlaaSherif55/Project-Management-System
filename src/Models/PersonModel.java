package Models;

import Repositories.PersonRepository;

public class PersonModel {

    private int id;
    private String name;
    private int age;
    private String username;
    private String password;
    private String role;
    private double salary;
    private int managerid;
    
    public void setId(int id) {
        this.id = id;
    }

    public PersonModel() {

    }
    
    public PersonModel(String name, int age, String username, String password, String role, double salary) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salary = salary;
    }

    public PersonModel(int id, String name, int age, String username, String password, String role, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salary = salary;
    }

    public PersonModel(int id, String name, int age, String username, String password, String role, double salary, int managerid) {
        this.id = id;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salary = salary;
        this.managerid = managerid;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static PersonModel login(String pass, String userName) {
        return PersonRepository.login(pass, userName);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age=" + age + ", username=" + username + ", password=" + password + ", role=" + role + ", salary=" + salary + ", managerid=" + managerid + '}';
    }

}
