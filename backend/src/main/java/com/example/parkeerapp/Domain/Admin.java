package com.example.parkeerapp.Domain;


import javax.persistence.*;

@Entity
@Table(name= "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;


    public  Admin(){

    }

    public Admin(Builder builder) {
        setId(builder.id);
        setUser(builder.user);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user=" + user +
                '}';
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

    public static final class Builder{
        private long id;
        private User user;

        public Builder(){

        }

        public Builder(Admin copy){
            this.id = copy.getId();
            this.user = copy.getUser();
        }

        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder user(User val){
            user = val;
            return this;
        }

        public Admin build(){return new Admin(this);}
    }

}
