package org.akee.prj22.school_management.library.service.impl;

import java.util.List;

import org.akee.prj22.school_management.library.model.ClassRoom;
import org.akee.prj22.school_management.library.repository.ClassRoomRepository;
import org.akee.prj22.school_management.library.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl implements ClassroomService {

	@Autowired
	private ClassRoomRepository roomRepository;

	@Override
	public List<ClassRoom> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public ClassRoom save(ClassRoom category) {
		try {
			ClassRoom entity = new ClassRoom(category.getName());
			return roomRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClassRoom findById(Long id) {
		return roomRepository.findById(id).get();
	}

	@Override
	public ClassRoom update(ClassRoom category) {
		ClassRoom entity = new ClassRoom(category);
		return roomRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		ClassRoom entity = roomRepository.findById(id).get();
		entity.set_activated(false);
		entity.set_deleted(true);
		roomRepository.save(entity);
	}

	@Override
	public void enabledById(Long id) {
		ClassRoom entity = roomRepository.findById(id).get();
		entity.set_activated(true);
		entity.set_deleted(false);
		roomRepository.save(entity);
	}

	@Override
	public boolean checkValidName(ClassRoom category) {
		ClassRoom entity = roomRepository.findByName(category.getName());
		if (category.getId() != null && entity != null) {
			return category.getId() == entity.getId();
		}
		return entity == null ? false : true;
	}

}
