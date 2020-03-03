package ru.specialist.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

@Service("jpaCourseService")
@Transactional
@Repository  //объявляем это бином courseDao
public class JPADAO implements CourseDAO {
	private static final Log LOG = LogFactory.getLog(JPADAO.class); //Журнал логов. определяем к кому будет привязан
	@PersistenceContext              //контекст хранения данных. Вебсервер будет правильно управлять этим контекстом
	private EntityManager em;
	
	public static Log getLog() {
		return LOG;
	}
	@Override
	@Transactional(readOnly = true)
	public Course findById(int id) {
		TypedQuery<Course> query= em.createQuery("select c from Course c where c.id = :id", Course.class);
		query.setParameter("id", id);
		return query.getSingleResult();
		// em.createNativeQuery(sqlString); -- работа на чистом sql
		
		
		//old return (Course)getSessionFactory().getCurrentSession().byId(Course.class).load(id); //конвертируем в Course т.к obj это как раз он, чтобы пеедать
		}
	
	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll(){     // c - переменная цикла. сущности. с.title - коллекция строк сущностей
	return em.createQuery("select c from Course c", Course.class).getResultList();
		//old hebirnate return getSessionFactory().getCurrentSession().createQuery("from Course c").list();  //источник данных не таблица courses, а множество сущностей, имя совпало
		 }
	@Override
	@Transactional(readOnly = true)
	public List<Course> findByTitle(String title) {
		TypedQuery<Course> query =
		em.createQuery("SELECT c from Course c where c.title LIKE :title", Course.class);
		 query.setParameter("title", "%"+title.trim()+"%");  //trim убирает пробелы в начале и конце строки
		 return query.getResultList();
	}
	@Override
	public void insert(Course course) {
	
		em.persist(course);
		LOG.info("Course saved with id:" + course.getId());
		
	}
	@Override
	public void update(Course course) {
		if(course.getId()!=0 && em.find(Course.class, course.getId())!=null)  em.merge(course);
		LOG.info("Course updated with id: " + course.getId());
		
	}
	@Override
	public void delete(int id) {
		em.remove(findById(id));
		LOG.info("Course deleted with id:" + id);
		
	}

}
