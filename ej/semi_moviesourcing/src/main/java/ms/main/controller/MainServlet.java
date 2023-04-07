package ms.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.main.model.service.MainService;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			MainService service = new MainService();
			
			service.selectDB();
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jspwork/main.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

}
