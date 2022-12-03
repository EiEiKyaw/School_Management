package org.akee.prj22.school_management.admin.config;

import java.util.stream.Collectors;

import org.akee.prj22.school_management.library.model.AdminUser;
import org.akee.prj22.school_management.library.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminUserServiceConfig implements UserDetailsService {

	@Autowired
	private AdminUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminUser user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find username");
		}
		return new User(
				user.getUserName(), 
				user.getPassword(), 
				user.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	}

}
