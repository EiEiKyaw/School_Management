package org.akee.prj22.school_management.library.service.impl;

import java.util.Arrays;

import org.akee.prj22.school_management.library.dto.AdminUserDto;
import org.akee.prj22.school_management.library.model.AdminUser;
import org.akee.prj22.school_management.library.repository.AdminUserRepository;
import org.akee.prj22.school_management.library.repository.RoleRepository;
import org.akee.prj22.school_management.library.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AdminUser findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public AdminUser findByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public AdminUser save(AdminUserDto userDto) {
		AdminUser userModel = new AdminUser(userDto);
		userModel.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
		return userRepository.save(userModel);
	}

}
