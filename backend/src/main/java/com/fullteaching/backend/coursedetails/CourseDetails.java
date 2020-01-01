package com.fullteaching.backend.coursedetails;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

import com.fullteaching.backend.forum.Forum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.filegroup.FileGroup;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length=100000)
	private String info;

	@OneToOne(cascade=CascadeType.ALL)
	private Forum forum;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<FileGroup> files;
	
	@JsonIgnore
	@OneToOne(mappedBy="courseDetails")
	private Course course;

	public CourseDetails(Course course) {
		this.info = "";
		this.course = course;
		this.forum = new Forum();
		this.files =  new ArrayList<>();
	}

	
}