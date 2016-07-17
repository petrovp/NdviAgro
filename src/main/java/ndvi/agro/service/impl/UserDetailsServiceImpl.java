package ndvi.agro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ndvi.agro.persistance.datamodel.Authority;
import ndvi.agro.persistance.datamodel.User;
import ndvi.agro.service.UserService;

/**
 * User details service.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User userFromDatabase = userService.findByUsername(s);

        if (userFromDatabase != null) {
        	Authority authority = userFromDatabase.getAuthority();
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));

            return new org.springframework.security.core.userdetails.
            		User(s,
            		userFromDatabase.getPassword(), 
            		grantedAuthorities);

        } else {
            throw new UsernameNotFoundException("User with username "+ s + " was not found in the database.");
        }

    }
}
