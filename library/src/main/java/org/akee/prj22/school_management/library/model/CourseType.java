package org.akee.prj22.school_management.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_type", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CourseType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private boolean is_deleted;

	private boolean is_activated;

	public CourseType(String name) {
		this.name = name;
		this.is_activated = true;
		this.is_deleted = false;
	}

	public CourseType(CourseType courseType) {
		if (courseType.getId() != null) {
			this.id = courseType.getId();
		}
		this.name = courseType.name;
		this.is_activated = courseType.is_activated();
		this.is_deleted = courseType.is_deleted();
	}

}
