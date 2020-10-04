package tech.youvsyou.connect4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.youvsyou.connect4.entity.UserInfo;
import tech.youvsyou.connect4.repository.UserInfoRepository;
import tech.youvsyou.connect4.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public boolean register(String username, String password, String emailId) {
        UserInfo userInfo = new UserInfo(username, passwordEncoder.encode(password), emailId);
        Optional<UserInfo> user = userInfoRepository.findById(username);
        if(user.isPresent()){
            return false;
        }
        userInfoRepository.save(userInfo);
        return true;
    }
}
