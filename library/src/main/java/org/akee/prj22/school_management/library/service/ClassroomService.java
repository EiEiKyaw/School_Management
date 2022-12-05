package org.akee.prj22.school_management.library.service;

import java.util.List;

import org.akee.prj22.school_management.library.model.ClassRoom;

public interface ClassroomService {

	List<ClassRoom> findAll();

	ClassRoom save(ClassRoom category);

	ClassRoom findById(Long id);

	ClassRoom update(ClassRoom category);

	void deleteById(Long id);

	void enabledById(Long id);

	boolean checkValidName(ClassRoom category);

}
