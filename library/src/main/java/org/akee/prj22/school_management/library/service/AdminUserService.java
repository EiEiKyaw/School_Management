package org.akee.prj22.school_management.library.service;

import org.akee.prj22.school_management.library.dto.AdminUserDto;
import org.akee.prj22.school_management.library.model.AdminUser;

public interface AdminUserService {
	
	AdminUser findByUserName(String userName);
	
	AdminUser findByUserNameAndPassword(String userName, String password);
	
	AdminUser save(AdminUserDto user);

}
