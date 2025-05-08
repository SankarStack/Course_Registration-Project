package com.example.Course_Register_React_SpringBoot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPwd {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String varsh = "$2a$12$bme0xiJ.UoCtAI4tGlcgqO5znFogVWTOLxpvxCObhsQplCjEX7/f.";
        String pwd = "Varsha7";
        String result  = encoder.encode(pwd);
        System.out.println("Result ->  "+result);
    }
}
