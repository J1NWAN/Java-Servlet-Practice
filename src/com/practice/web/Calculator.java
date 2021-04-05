package com.practice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "서블릿을 이용한 계산기 구현", urlPatterns = { "/calc" })
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2;
		int result;
		String op;
		
		response.setContentType("text/html); charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		
		op = request.getParameter("operator");
		
		result = calc(num1, num2, op);
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>CALCULATOR</TITLE></HEAD>");
		out.println("<body><center>");
		out.println("<h2>CALCULATING RESULTE</h2><hr>");
		out.println(num1+" "+op+" "+num2+" = "+result);
		out.println("</body></html>");
	}

	private int calc(int num1, int num2, String op) {
		int result = 0;
		
		if(op.equals("+")) result = num1 + num2;
		else if(op.equals("-")) result = num1 - num2;
		else if(op.equals("*")) result = num1 * num2;
		else if(op.equals("/")) result = num1 / num2;
		
  		return result;
	}
}