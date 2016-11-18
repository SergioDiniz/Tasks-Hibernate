package dao;

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
	
}
