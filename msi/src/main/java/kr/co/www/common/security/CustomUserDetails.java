package kr.co.www.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    
	private static final long serialVersionUID = -4450269958885980297L;
    private String user_id;
    private String user_pw;
    private String user_name;

    public CustomUserDetails(String user_id, String user_pw){
        this.user_id = user_id;
        this.user_pw = user_pw;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
    
    public String getUser_id() {
		return user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	@Override
	public String getUsername() {
		return user_name;
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

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


}
