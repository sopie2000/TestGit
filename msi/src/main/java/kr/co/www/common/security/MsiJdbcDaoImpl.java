package kr.co.www.common.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import kr.co.www.common.security.MemberInfo;

/**
 * @Class Name : MsiJdbcDaoImpl.java
 * @Description : JdbcDaoSupport 클래스를 상속하고 있으며 사용자 정보를 조회하기 위한 목적으로 UserDetailsService 인터페이스를 사용
 * @Modification Information
 * @
 * @  수정일         		수정자                   수정내용
 * @ -------------------------------------------------
 * @ 2016. 11. 11.    sopie         
 *
 * @author sopie    
 * @since 2016. 11. 11.
 * @version 1.0
 * @see
 */
public class MsiJdbcDaoImpl extends JdbcDaoImpl {

	Logger logger = LoggerFactory.getLogger(MsiJdbcDaoImpl.class);
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		
		logger.info("step1");
		
		List<UserDetails> users = loadUsersByUsername(username);
		
		logger.info("step2" + users.get(0).getAuthorities());
		logger.info("user size =======> " + users.size());
		
		if (users.size() == 0) {
			logger.info("step3");
			logger.info("검색된 사용자가 없습니다. " + username);
		
			UsernameNotFoundException ue = new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
			throw ue;
		}
		
		MemberInfo user = (MemberInfo)users.get(0);
		logger.info("step4");
		Set<GrantedAuthority> dbAuthSet = new HashSet<GrantedAuthority>();
		
		if (getEnableAuthorities()){
			logger.info("getEnableAuthorities() 발동");
			dbAuthSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		
		if(getEnableGroups()){
			dbAuthSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthSet);
		user.setAuthorities(dbAuthSet);
		
		if(dbAuths.size() == 0){
			logger.info("User : " + username + " has no authorities and will be treated as not found");
			UsernameNotFoundException ue = new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.noAuthority", new Object[]{username}, "User {0} has no GrantedAuthority"));
			throw ue;
		}
		
		return super.loadUserByUsername(username);
	}
	
	/**
	 * JdbcTemplate를 이용해서 DB를 조회한 뒤  UserDeatil 인터페이스 객체들이 들어있는 List 인터페이스 객체를 리턴한다.
	 * 
	 */
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		
		return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>(){
			
			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				logger.info("회원조회1 ===>" + rs.getString(1));
				logger.info("회원조회2===>" + rs.getString(2));
				logger.info("회원조회3===>" + rs.getString(3));
				
				String user_id = rs.getString(1);
				String user_pw = rs.getString(2);
				String name = rs.getString(3);
				
			/*	UserSessionVo vo = new UserSessionVo();
				vo.setUser_id(username);
				vo.setUser_pw(password);
				vo.setUser_name(name);*/
				//return new User(user_id, user_pw, true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
				return new MemberInfo(user_id, user_pw, name, AuthorityUtils.NO_AUTHORITIES);
			}
		});
	}
	
	/**
	 * 권한조회
	 */
	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(),
				new String[] {username}, new RowMapper<GrantedAuthority>() {
			@Override
			public GrantedAuthority mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String roleName = getRolePrefix() +rs.getString(1);
				logger.info("roleName = > " + roleName);
				return new SimpleGrantedAuthority(roleName);
			}
		});
	}
	
/*	@Override
	protected List<GrantedAuthority> loadGroupAuthorities(String username) {
		return super.loadGroupAuthorities(username);
	}*/
}
