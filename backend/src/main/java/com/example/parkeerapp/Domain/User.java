package com.example.parkeerapp.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastname;

    @Column(name="USERNAME", unique = true)
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="ROLE")
    private String role;

    @Column(name="EMAIL", unique = true)
    private String email;
    @OneToMany(mappedBy = "member")
    private Set<Car> cars;

    public User(){

    }

    public User(String firstName, String lastname,  String password, String role, String email) {
        this.firstName = firstName;
        this.lastname = lastname;

        this.password = password;
        this.role = role;
        this.email = email;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }


    public String getFullName() {
        return firstName + " " + lastname ;
    }
    public Set<Car> getCars() {
        return cars;
    }
    public Set<Reservation> getReservations(){
        Set<Reservation> reservations = new HashSet<>();
        for (Car car : this.getCars()){
            for(Reservation reservation : car.getReservations()){
                reservations.add(reservation);
            }
        }
        return reservations;
    }
    private User(Builder builder){
        setId(builder.id);
        setFirstName(builder.firstname);
        setLastName(builder.lastname);
        setUsername(builder.username);
        setPassword(builder.password);
        setEmail(builder.email);
        setRole(builder.role);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class Builder{

        private long id;
        private String firstname;
        private String lastname;
        private String username;
        private String password;
        private String role;
        private String email;

        public Builder(){

        }

        public Builder(User copy){
            this.id = copy.getId();
            this.firstname = copy.getFirstname();
            this.lastname = copy.getLastname();
            this.username = copy.getUsername();
            this.password = copy.getPassword();
            this.role = copy.getRole();
            this.email = copy.getEmail();
        }

        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder firstname(String val){
            firstname = val;
            return this;
        }

        public Builder lastname(String val){
            lastname = val;
            return this;
        }

        public Builder username(String val){
            username = val;
            return this;
        }

        public Builder password(String val){
            password = val;
            return this;
        }

        public Builder role(String val){
            role = val;
            return this;
        }

        public Builder email(String val){
            email = val;
            return this;
        }

        public User build(){return new User(this);}
    }

}