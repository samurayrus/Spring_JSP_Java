package ru.specialist.hebirnate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main( String[] args )
{
	ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	CourseDAO courseDao = context.getBean(CourseDAO.class);
	for(Course c : courseDao.findAll())
		{System.out.println(c);
		courseDao.delete(7);
		}
	
	context.close();
}



}
