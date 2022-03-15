package com.example.parkeerapp.Domain;


import javax.persistence.*;

@Entity
@Table(name= "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Member_ID")
    private Member member;


    public  Admin(){

    }

    public Admin(Builder builder) {
        setId(builder.id);
        setMember(builder.member);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user=" + member +
                '}';
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public Member getMember() {return member;}

    public void setMember(Member member) {this.member = member;}

    public static final class Builder{
        private long id;
        private Member member;

        public Builder(){

        }

        public Builder(Admin copy){
            this.id = copy.getId();
            this.member = copy.getMember();
        }

        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder member(Member val){
            member = val;
            return this;
        }

        public Admin build(){return new Admin(this);}
    }

}
