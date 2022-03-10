package com.example.parkeerapp.DTO;

import java.util.Set;

public class MemberSimpleDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String role;

    public MemberSimpleDTO(){

    }

    public MemberSimpleDTO(Builder builder){
        setId(builder.id);
        setFirstname(builder.firstname);
        setLastname(builder.lastname);
        setRole(builder.role);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static final class Builder{

        private long id;
        private String firstname;
        private String lastname;
        private String role;

        public Builder(){

        }

        public Builder(MemberSimpleDTO copy){
            this.id = copy.getId();
            this.firstname = copy.getFirstname();
            this.lastname = copy.getLastname();
            this.role = copy.getRole();
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

        public MemberSimpleDTO build(){return new MemberSimpleDTO(this);}
    }
}