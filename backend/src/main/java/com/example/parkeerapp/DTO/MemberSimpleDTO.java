package com.example.parkeerapp.DTO;

public class MemberSimpleDTO {
    private long id;
    private UserSimpleDTO UserSimpleDTO;

    public MemberSimpleDTO(){}

    private MemberSimpleDTO(Builder builder){
        setId(builder.id);
        setUserSimpleDTO(builder.userSimpleDTO);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserSimpleDTO getUserSimpleDTO() {
        return UserSimpleDTO;
    }

    public void setUserSimpleDTO(UserSimpleDTO userSimpleDTO) {
        UserSimpleDTO = userSimpleDTO;
    }


    public static final class Builder {
        private long id;
        private UserSimpleDTO userSimpleDTO;


        public Builder(){}

        public Builder(MemberSimpleDTO copy) {
            this.id = copy.getId();

            this.userSimpleDTO = copy.getUserSimpleDTO();
        }

        public Builder user(UserSimpleDTO val){
            userSimpleDTO = val;
            return this;
        }

        public Builder id(Long val){
            id = val;
            return this;
        }


        public MemberSimpleDTO build(){return new MemberSimpleDTO(this);}
    }
}
