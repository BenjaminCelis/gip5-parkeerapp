package com.example.parkeerapp.config;


import com.example.parkeerapp.DTO.UserLoginDTO;
import com.example.parkeerapp.dao.UserRepository;
import com.example.parkeerapp.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserUserDetailService")
public class UserUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println(s);
        User user = userRepository.findFirstByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found",s)));
        return new UserPrincipal(user);
    }

    public UserDetails Login(UserLoginDTO userLoginDTO) throws Exception {

        UserDetails user = loadUserByUsername(userLoginDTO.getUsername());
        if(!passwordEncoder.matches(userLoginDTO.getPassword(),user.getPassword())){
            throw new Exception(String.format("User %s not found",userLoginDTO.getUsername()));
        }

        System.out.println(user.toString());
        return user;
    }
}