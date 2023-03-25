package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private RemoteUserService remoteUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = remoteUserService.selectUserByUsername(username);
        if(null==user){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<String> permissions = remoteUserService.selectUserPermissions(user.getId());
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User
                (username, user.getPassword(), AuthorityUtils.createAuthorityList(permissions.toArray(new String[0])));
        return user1;
    }
}
