package ms.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.main.model.service.MainService;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private MainService mainService;
	public MainServlet() {
		this.mainService = new MainService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			req.setAttribute("result", mainService.selectMainContent());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jspwork/main.jsp");
			dispatcher.forward(req, res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}