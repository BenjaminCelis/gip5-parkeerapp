package com.example.parkeerapp.DTO;

public class CreateMemberDTO {

    private long id;
    private MemberDTO memberDTO;
    private String password;

    public CreateMemberDTO(){}

    private CreateMemberDTO(Builder builder){
        setId(builder.id);
        setMemberDTO(builder.memberDTO);
        setPassword(builder.password);
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public MemberDTO getMemberDTO() {return memberDTO;}

    public void setMemberDTO(MemberDTO memberDTO) {this.memberDTO = memberDTO;}

    @Override
    public String toString() {
        return "CreateMemberDTO{" +
                "id=" + id +
                ", memberDTO=" + memberDTO +
                ", password='" + password +
                '}';
    }

    public static final class Builder {
        private long id;
        private MemberDTO memberDTO;
        private String password;


        public Builder(){}

        public Builder(CreateMemberDTO copy){
            this.id = copy.getId();
            this.memberDTO = copy.getMemberDTO();
            this.password = copy.getPassword();
        }

        public Builder member(MemberDTO val){
            memberDTO = val;
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

