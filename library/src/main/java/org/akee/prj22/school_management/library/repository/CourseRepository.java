package org.akee.prj22.school_management.library.repository;

import org.akee.prj22.school_management.library.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
