package servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Task;
import dao.TaskDao;

/**
 * Servlet implementation class AdicionaTask
 */
@WebServlet("/adicionaTask")
public class AdicionaTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String descricao = request.getParameter("descricao");
		
		Task t = new Task();
		t.setDescricao(descricao);
		t.setDataCriacao(Calendar.getInstance());
		t.setFinalizado(false);
		
		TaskDao dao = new TaskDao();
		dao.addTask(t);
		
		System.out.println("ok");
		
		response.sendRedirect("listar-task.jsp");
		
	}

}
