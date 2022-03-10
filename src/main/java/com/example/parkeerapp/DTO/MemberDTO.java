package com.example.parkeerapp.DTO;


import java.io.Serializable;

public class MemberDTO implements Serializable {

    private long id;
    private String firstname;
    private String lastname;
    private String role;
    private String email;


    public MemberDTO(){

    }
    public MemberDTO(Builder builder){
        setId(builder.id);
        setFirstname(builder.firstname);
        setLastname(builder.lastname);
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

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class Builder{

        private long id;
        private String firstname;
        private String lastname;
        private String role;
        private String email;

        public Builder(){

        }

        public Builder(MemberDTO copy){
            this.id = copy.getId();
            this.firstname = copy.getFirstname();
            this.lastname = copy.getLastname();
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


        public Builder role(String val){
            role = val;
            return this;
        }

        public Builder email(String val){
            email = val;
            return this;
        }

        public MemberDTO build(){return new MemberDTO(this);}
    }

}
