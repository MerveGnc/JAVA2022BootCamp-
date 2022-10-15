package dataAccess.course;

import entities.Course;

public class HibernateCourseDao implements CourseDao {
	
	@Override
	public void add(Course course) {
		System.out.println("Kurs Hibernate ile veri tabanına eklendi.");
	}

}
