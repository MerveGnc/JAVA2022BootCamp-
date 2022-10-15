package business;

import java.util.ArrayList;
import core.logging.Logger;

import dataAccess.course.CourseDao;
import entities.Course;

public class CourseManager {

	private CourseDao courseDao;
	private Logger[] loggers;
	ArrayList<String> courseNames =new ArrayList<String>();

	public CourseManager(CourseDao courseDao,Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers=loggers;
	}
	

	public void add(Course course) throws Exception {
		if (course.getPrice() < 0) {
			throw new Exception("Kurs fiyatı 0'dan küçük olamaz ");
		}
		
		for (String courseName : courseNames ) {
			if(courseName==course.getCourseName()) {
				throw new Exception("Kurs adı aynı olamaz.");
			}
			
		}
		courseNames.add(course.getCourseName());
		courseDao.add(course);
		
		for(Logger logger: loggers) {
			logger.log(course.getCourseName());
		}

	}

}
