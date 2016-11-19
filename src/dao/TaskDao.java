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
		long tempoInicial = System.currentTimeMillis();
		
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		
		long tempoFinal = System.currentTimeMillis();
		System.out.println("tempo para Iniciar Dao: " + (tempoFinal - tempoInicial));
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
			long tempoInicial = System.currentTimeMillis();
			Query query = session.createQuery("from Task");
			tasks = query.getResultList();
			long tempoFinal = System.currentTimeMillis();
			System.out.println("tempo para listar: " + (tempoFinal - tempoInicial));
			
		} finally {
			factory.close();
			session.close();
		}
		
		return tasks;
	}
	
}
