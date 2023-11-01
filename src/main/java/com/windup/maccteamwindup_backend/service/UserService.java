//package com.windup.maccteamwindup_backend.service;
//import com.windup.maccteamwindup_backend.domain.UserEntity;
//import com.windup.maccteamwindup_backend.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        UserEntity userEntity = userRepository.findByUserId(username)
//                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
//
//        if (userEntity.getUserId().equals(username)) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//
//        return new User(userEntity.getUserId(), userEntity.getPassword(), authorities);
//    }
//}
