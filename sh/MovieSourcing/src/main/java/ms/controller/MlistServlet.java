package ms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.service.mlistService;

@WebServlet("")
public class MlistServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		super.doPost(req, resp);
	
		try {
			
			mlistService service = new mlistService();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	
	
	}
}
