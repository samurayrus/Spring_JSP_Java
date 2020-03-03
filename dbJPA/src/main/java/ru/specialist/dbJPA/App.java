package ru.specialist.dbJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;
 
public class App 
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CourseDAO courseDao = context.getBean(CourseDAO.class);
		
		for(Course c : courseDao.findAll())
			{System.out.println(c);
			}
		System.out.println("________________________X_____________________________");
		System.out.println("________________________1_____________________________"+courseDao.findAll());
		//courseDao.findAll();
		System.out.println("________________________2_____________________________"+ courseDao.findById(8));
		//courseDao.findById(2);
		System.out.println("________________________3_____________________________"+courseDao.findByTitle("web"));
		//courseDao.findByTitle("web");
		System.out.println("________________________4_____________________________");
		courseDao.delete(33);
		System.out.println("________________________END_____________________________");
		
		context.close();
	}
}
