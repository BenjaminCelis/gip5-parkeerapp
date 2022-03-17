package com.example.parkeerapp.Domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name= "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;



    public Member(){

    }

    private Member(Builder builder){
        setId(builder.id);
        setUser(builder.user);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }






    public static final class Builder {
        private long id;
        private User user;

        public Builder(){}

        public Builder(Member copy){
            this.id = copy.getId();
            this.user = copy.getUser();

        }

        public Builder user(User val){
            user = val;
            return this;
        }


        public Builder id(Long val){
            id = val;
            return this;
        }

        public Member build(){return new Member(this);}
    }

}