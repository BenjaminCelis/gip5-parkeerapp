package com.example.parkeerapp.DTO;

public class CreateMemberDTO {

    private long id;
    private UserDTO userDTO;
    private String password;

    public CreateMemberDTO(){}

    private CreateMemberDTO(Builder builder){
        setId(builder.id);
        setUserDTO(builder.userDTO);
        setPassword(builder.password);
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public UserDTO getUserDTO() {return userDTO;}

    public void setUserDTO(UserDTO userDTO) {this.userDTO = userDTO;}
    @Override
    public String toString() {
        return "CreateSpelerDTO{" +
                "id=" + id +
                ", userDTO=" + userDTO +
                ", password='" + password +
                '}';
    }

    public static final class Builder {
        private long id;
        private UserDTO userDTO;
        private String password;


        public Builder(){}

        public Builder(CreateMemberDTO copy){
            this.id = copy.getId();
            this.userDTO = copy.getUserDTO();
            this.password = copy.getPassword();
        }

        public Builder user(UserDTO val){
            userDTO = val;
            return this;
        }
        public Builder id(Long val){
            id = val;
            return this;
        }

        public Builder password(String val){
            password = val;
            return this;
        }

        public CreateMemberDTO build(){return new CreateMemberDTO(this);}
    }

}

