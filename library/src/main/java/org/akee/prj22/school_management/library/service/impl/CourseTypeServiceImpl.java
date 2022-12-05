package org.akee.prj22.school_management.library.service.impl;

import java.util.List;

import org.akee.prj22.school_management.library.model.CourseType;
import org.akee.prj22.school_management.library.repository.CourseTypeRepository;
import org.akee.prj22.school_management.library.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

	@Autowired
	private CourseTypeRepository courseTypeRepository;

	@Override
	public List<CourseType> findAll() {
		return courseTypeRepository.findAll();
	}

	@Override
	public CourseType save(CourseType courseType) {
		try {
			CourseType entity = new CourseType(courseType.getName());
			return courseTypeRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CourseType getById(Long id) {
		return courseTypeRepository.findById(id).get();
	}

	@Override
	public CourseType update(CourseType courseType) {
		CourseType entity = new CourseType(courseType);
		return courseTypeRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		CourseType entity = courseTypeRepository.findById(id).get();
		entity.set_activated(false);
		entity.set_deleted(true);
		courseTypeRepository.save(entity);
	}

	@Override
	public void enabledById(Long id) {
		CourseType entity = courseTypeRepository.findById(id).get();
		entity.set_activated(true);
		entity.set_deleted(false);
		courseTypeRepository.save(entity);
	}

	@Override
	public boolean checkValidName(CourseType courseType) {
		CourseType entity = courseTypeRepository.findByName(courseType.getName());
		if (courseType.getId() != null && entity != null) {
			return courseType.getId() == entity.getId();
		}
		return entity == null ? false : true;
	}

}
