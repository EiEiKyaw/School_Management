package org.akee.prj22.school_management.library.repository;

import org.akee.prj22.school_management.library.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long>{

	ClassRoom findByName(String name);

}
