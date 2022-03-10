package com.example.parkeerapp.Domain;


import javax.persistence.*;

@Entity
@Table(name= "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="ROLE")
    private String role;

    @Column(name="EMAIL", unique = true)
    private String email;

    public Member(){

    }

    private Member(Builder builder){
        setId(builder.id);
        setFirstname(builder.firstname);
        setLastname(builder.lastname);
        setPassword(builder.password);
        setEmail(builder.email);
        setRole(builder.role);
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class Builder{

        private long id;
        private String firstname;
        private String lastname;
        private String password;
        private String role;
        private String email;

        public Builder(){

        }

        public Builder(Member copy){
            this.id = copy.getId();
            this.firstname = copy.getFirstname();
            this.lastname = copy.getLastname();
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

        public Member build(){return new Member(this);}
    }

}