package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Task;

public class TaskDao {

	private Session session;
	private SessionFactory factory;
	
	public TaskDao(){
		
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		
	}
	
	public void addTask(Task task){
		
		try {
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}
		
	}
	
	public List<Task> listarTask(){
		
		List<Task> tasks;
		
		try {
			
			Query query = session.createQuery("from Task");
			tasks = query.getResultList();
			
		} finally {
			factory.close();
			session.close();
		}
		
		return tasks;
	}
	
}
