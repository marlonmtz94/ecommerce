package com.marlon.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.marlon.model.User;

public class GroupUserDetails  implements UserDetails {
	
	private String email;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;
    
    
    public GroupUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
      //  this.isActive = user.isActive();
        this.authorities = Arrays.stream(user.getPermission().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    // the email is the username so we return the email 
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
    
    
    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    


}
