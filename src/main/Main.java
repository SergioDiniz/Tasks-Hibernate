package main;

import java.util.Calendar;

import beans.Task;
import dao.TaskDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TaskDao dao = new TaskDao();
		
		Task t = new Task();
		t.setDataCriacao(Calendar.getInstance());
		t.setDescricao("Descrição");
		t.setFinalizado(false);
		
		dao.addTask(t);
		
		System.out.println("ok!");
	}

}
