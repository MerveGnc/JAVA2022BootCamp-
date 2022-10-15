import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.category.CategoryDao;
import dataAccess.category.HibernateCategoryDao;
import dataAccess.category.JdbcCategoryDao;
import dataAccess.course.JdbcCourseDao;
import dataAccess.instructor.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Course course1=new Course(1,"Yazılım Geliştirici Yetiştirme Kampı: C# + ANGULAR",0);
		Course course2=new Course(2,"Senior Yazılım Geliştirici Yetiştirme Kampı: .NET",0);
		Course course3=new Course(3,"Yazılım Geliştirici Yetiştirme Kampı: JavaScript",0);
		Course course4=new Course(4,"Yazılım Geliştirici Yetiştirme Kampı: JAVA + REACT",0);
		Course course5=new Course(5,"Yazılım Geliştirici Yetiştirme Kampı: JAVA",0);
		Course course6=new Course(6,"Proglamlamaya Giriş için Temel Kurs",0);
		
		
		Category category1=new Category(1,"Tümü");
		Category category2=new Category(2,"Programlama");
		
		Instructor instructor=new Instructor(1,"Engin","Demiroğ");
		
		Logger[] loggers= {new DatabaseLogger(),new FileLogger(),new MailLogger()};
		
		
		CategoryManager categoryManager=new CategoryManager(new JdbcCategoryDao(),loggers);
		categoryManager.add(category1);
		categoryManager.add(category2);
		
		
		CourseManager courseManager=new CourseManager(new JdbcCourseDao(),loggers);
		courseManager.add(course1);
		courseManager.add(course2);
		courseManager.add(course3);
		courseManager.add(course4);
		courseManager.add(course5);
		courseManager.add(course6);
		
		
		InstructorManager instructorManager=new InstructorManager(new JdbcInstructorDao(),loggers);
		instructorManager.add(instructor);
		
		
		
	}

}
