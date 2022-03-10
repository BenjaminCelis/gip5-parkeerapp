package com.example.parkeerapp.DTO;

import java.io.Serializable;

public class AdminDTO implements Serializable {
    private long id;
    private MemberDTO memberDTO;
    private String passwoord;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MemberDTO getMemberDTO() {return memberDTO;}

    public void setMemberDTO(MemberDTO memberDTO) {this.memberDTO = memberDTO;}

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", memberDTO=" + memberDTO +
                ", passwoord='" + passwoord + '\'' +
                '}';
    }

    public AdminDTO(){

    }

    public AdminDTO(Builder builder){
        setId(builder.id);
        setMemberDTO(builder.memberDTO);
        setPasswoord(builder.passwoord);
    }

    public static final class Builder {
        private long id;
        private MemberDTO memberDTO;
        private String passwoord;

        public Builder(){

        }

        public Builder(AdminDTO copy){
            this.id = copy.getId();
            this.memberDTO = copy.getMemberDTO();
            this.passwoord = copy.getPasswoord();
        }

        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder memberDTO(MemberDTO val){
            memberDTO = val;
            return this;
        }

        public Builder passwoord(String val){
            passwoord = val;
            return this;
        }

        public AdminDTO build(){return new AdminDTO(this);}
    }
}

