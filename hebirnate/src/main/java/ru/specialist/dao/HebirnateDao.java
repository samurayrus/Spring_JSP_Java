package ru.specialist.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
@Transactional
@Repository("courseDao")  //объявляем это бином courseDao
public class HebirnateDao implements CourseDAO {
	private static final Log LOG = LogFactory.getLog(HebirnateDao.class); //Журнал логов. определяем к кому будет привязан
	private SessionFactory sessionFactory;
	
	

	@Resource(name="sessionFactory")  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Log getLog() {
		return LOG;
	}
	@Override
	@Transactional(readOnly = true)
	public Course findById(int id) {
		return (Course)getSessionFactory().getCurrentSession().byId(Course.class).load(id); //конвертируем в Course т.к obj это как раз он, чтобы пеедать
		}
	
	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll(){
		return getSessionFactory().getCurrentSession().createQuery("from Course c").list();  //источник данных не таблица courses, а множество сущностей, имя совпало
		 }
	@Override
	public List<Course> findByName(String title) {
		
		return null;
	}
	@Override
	public void insert(Course course) {
		getSessionFactory().getCurrentSession().save(course);
		LOG.info("Course saved with id:");
		
	}
	@Override
	public void update(Course course) {
		getSessionFactory().getCurrentSession().update(course);
		LOG.info("Course updated with id: " + course.getId());
		
	}
	@Override
	public void delete(int id) {
		
		
	}

}
