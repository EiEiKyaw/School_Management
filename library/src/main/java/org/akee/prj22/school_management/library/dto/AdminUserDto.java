package org.akee.prj22.school_management.library.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDto {
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	@Size(min = 5, max = 15, message = "Invalid password ! (5-15 characters)")
	private String password;
	
	private String repeatPassword;

}
