package tech.youvsyou.connect4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tech.youvsyou.connect4.entity.UserInfo;
import tech.youvsyou.connect4.repository.UserInfoRepository;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserInfo> user = userInfoRepository.findById(s);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("user is not registered. Register first.");
    }
}
