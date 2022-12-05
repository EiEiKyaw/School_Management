package org.akee.prj22.school_management.library.service;

import java.util.List;

import org.akee.prj22.school_management.library.model.CourseType;

public interface CourseTypeService {

	List<CourseType> findAll();

	CourseType save(CourseType course);

	CourseType getById(Long id);

	CourseType update(CourseType course);

	void deleteById(Long id);

	void enabledById(Long id);

	boolean checkValidName(CourseType course);

}
