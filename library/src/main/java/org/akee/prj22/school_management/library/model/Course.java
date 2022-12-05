package org.akee.prj22.school_management.library.model;

import org.akee.prj22.school_management.library.enumeration.DiscountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private double costPrice;

	private double salePrice;

	private int discountValue;

	private DiscountType discountType;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "coursetype_id", referencedColumnName = "id")
	private CourseType courseType;

	private boolean is_activated;

	private boolean is_deleted;

}
