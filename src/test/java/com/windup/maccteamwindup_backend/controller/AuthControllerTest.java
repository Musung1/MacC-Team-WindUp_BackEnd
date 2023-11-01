//package com.windup.maccteamwindup_backend.controller;
//
//import com.windup.maccteamwindup_backend.domain.UserEntity;
//import com.windup.maccteamwindup_backend.dto.SignUpForm;
//import com.windup.maccteamwindup_backend.repository.UserRepository;
//import com.windup.maccteamwindup_backend.service.UserService;
//import net.minidev.json.JSONObject;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//class AuthControllerTest {
//    @Autowired private UserService userService;
//    @Autowired private UserRepository userRepository;
//    @Autowired
//    AuthenticationManager authenticationManager;
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private MockMvc mockMvc;
//    @Test
//    public void signUpTest(){
//        // given
//        SignUpForm signUpForm = new SignUpForm("musung","123","456");
//        // when
//
//        // then
//    }
//    @DisplayName("로그인 성공 테스트")
//    @Test
//    void loginTest() throws Exception {
//        String encPassword = passwordEncoder.encode("test_password");
//        UserEntity userEntity = UserEntity.of("name1","id1",encPassword);
//
//        UserEntity savedUserEntity = userRepository.save(userEntity);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("user_id", "id1");
//        jsonObject.put("user_pw", "test_password");
//
//        ResultActions result = mockMvc.perform(post("/login")
//                .content(jsonObject.toString())
//                .contentType(MediaType.APPLICATION_JSON));
//
//        MvcResult mvcResult = result.andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        System.out.println(mvcResult.getResponse().getContentAsString());
//    }
//
//}