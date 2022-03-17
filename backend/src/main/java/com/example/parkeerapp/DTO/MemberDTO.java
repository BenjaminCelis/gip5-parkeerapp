package com.example.parkeerapp.DTO;


import java.io.Serializable;

public class MemberDTO implements Serializable {

    private long id;
    private UserDTO userDTO;


    public MemberDTO(){

    }
    public MemberDTO(Builder builder){
        setId(builder.id);
        setUserDTO(builder.userDTO);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "SpelerDTO{" +
                "id=" + id +
                ", userDTO=" + userDTO +
                '}';
    }

    public static final class Builder {
        private long id;
        private UserDTO userDTO;

        public Builder(){

        }

        public Builder(MemberDTO copy){
            this.id = copy.getId();
            this.userDTO = copy.getUserDTO();
        }

        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder user(UserDTO val){
            userDTO = val;
            return this;
        }

        public MemberDTO build(){return new MemberDTO(this);}
    }

}
