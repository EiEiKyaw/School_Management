package org.akee.prj22.school_management.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.akee.prj22.school_management.library.*", "org.akee.prj22.school_management.admin.*"})
@EnableJpaRepositories(value = "org.akee.prj22.school_management.library.repository")
@EntityScan(value = "org.akee.prj22.school_management.library.model")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
