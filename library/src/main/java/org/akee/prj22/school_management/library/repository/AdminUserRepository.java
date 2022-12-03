package org.akee.prj22.school_management.library.repository;

import org.akee.prj22.school_management.library.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	
	AdminUser findByUserName(String userName);
	
	AdminUser findByUserNameAndPassword(String userName, String password);

}
