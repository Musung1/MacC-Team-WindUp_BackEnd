//package com.windup.maccteamwindup_backend.controller;
//
//import com.windup.maccteamwindup_backend.domain.UserEntity;
//import com.windup.maccteamwindup_backend.dto.SignUpForm;
//import com.windup.maccteamwindup_backend.repository.UserRepository;
//import com.windup.maccteamwindup_backend.service.UserService;
//import com.windup.maccteamwindup_backend.utils.JwtUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//    private final UserRepository userRepository;
//    private final UserService userService;
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
//        String userId = paramMap.get("user_id");
//        String userPw = paramMap.get("user_pw");
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encPassword = passwordEncoder.encode(userPw);
//
//        UserDetails loginUser = userService.loadUserByUsername(userId); //userId로 정보 가져오기
//
//        Authentication authentication = authenticationManager.authenticate(     //가져온 정보와 입력한 비밀번호로 검증
//                new UsernamePasswordAuthenticationToken(loginUser, userPw)
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);   // 검증 통과 후 authentication 세팅
//
//        String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());     //accessToken 생성
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("user_id", loginUser.getUsername());
//        result.put("user_token", accessToken);
//        result.put("user_role", loginUser.getAuthorities().stream().findFirst().get().getAuthority());
//
//        return ResponseEntity.ok(result);
//    }
//    @PostMapping("/signUp")
//    public void SignIn(@RequestBody SignUpForm signUpForm){
//        System.out.println(signUpForm.toString());
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encPassword = passwordEncoder.encode(signUpForm.getUserPw());
//        userRepository.save(UserEntity.of(signUpForm.getUserName(), signUpForm.getUserId(), encPassword));
//
//    }
//}
