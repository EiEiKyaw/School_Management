package org.akee.prj22.school_management.library.repository;

import org.akee.prj22.school_management.library.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {

	CourseType findByName(String name);

}
