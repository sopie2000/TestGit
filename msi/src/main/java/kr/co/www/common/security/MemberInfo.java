package kr.co.www.common.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class MemberInfo implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(MemberInfo.class);

	private String user_id;
	private String user_pw;
	private String user_name;
	private Set<GrantedAuthority> authorities;
	
	public MemberInfo(String user_id, String user_pw, String user_name, Collection<? extends GrantedAuthority> authorities) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}

	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}	

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	public String getUser_pw() {
		return user_pw;
	}
	
	@Override
	public String getPassword() {
		return user_pw;
	}


	@Override
	public String getUsername() {
		return user_id;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		logger.info("호출하나~~~~~~~~~~~~~~~~");
		
		return authorities;
	}
	
	
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
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
	

	

	
	private static SortedSet<GrantedAuthority> sortAuthorities (Collection<? extends GrantedAuthority> authorities) {
		
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());
		
		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.notNull(grantedAuthority,"GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}
		
		return sortedAuthorities;
	}
	
	
	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
		  
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
		
		@Override
		public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			
			if (g2.getAuthority() == null) {
				return -1;
			}
			
			if(g1.getAuthority() == null) {
				return 1;
			}
				
			return g1.getAuthority().compareTo(g2.getAuthority());
		}
	}
}