package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.pojo.Account;
import com.service.AccountService;
import com.serviceimpl.AccountServiceImpl;

public class AccountServlet extends HttpServlet {

	AccountService as = new AccountServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入accountservlet");
		String path = request.getRequestURI();
		System.out.println("path:"+path);
		int index = path.lastIndexOf("/");
		String realpath = path.substring(index+1);
		System.out.println("realpath:"+realpath);
		if(realpath.equals("check")){
			check(request,response);
		}if(realpath.equals("reset")){
			reset(request,response);
		}if(realpath.equals("turn")){
			turn(request,response);
		}if(realpath.equals("continue1")){
			continue1(request,response);
		}if(realpath.equals("quit")){
			quit(request,response);
		}
	}

	public void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========check=========");
		String accountname = request.getParameter("accountname");
		
		HttpSession  session = request.getSession();
		session.setAttribute("accountname",accountname);
		
		String password = request.getParameter("password");
		String waring1=null;
		String waring2=null;
		List<Account> list = as.getAccount();
		System.out.println("------------------"); 
		boolean flag = false;
		boolean jump = false;
		for(int i=0;i<list.size();i++){
			Account ac = list.get(i);
			if(ac.getAccount_number().equals(accountname)&&ac.getPassword().equals(password)){
				if(ac.getStatus()==1){
					jump = true;
					break;
				}else{
					waring1 = "帐号已经冻结";
					flag = false;
					break;
				}
			}else{
				flag = true;
			}
		}
		if(flag){
			waring2 = "帐号或者密码不对";
		}
		
		if(jump){
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			request.setAttribute("password", password);
			request.setAttribute("waring1",waring1);
			request.setAttribute("waring2",waring2);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	 
	public void reset(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=======reset==========");
		response.sendRedirect("login.jsp");
	}
	
	public void turn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==========turn===========");
		HttpSession  session = request.getSession();
		String acc1 = (String)session.getAttribute("accountname");
		
		System.out.println("acc1"+acc1);
		String acc2 = request.getParameter("accname");
		System.out.println(acc2);
		String mon = request.getParameter("money");
		float money = Float.parseFloat(mon);
		String waring1=null;
		String waring2=null;
		String waring3=null;
		List<Account> list = as.getAccount();
		System.out.println("------------------"); 
		boolean flag = false;
		boolean jump = false;
		for(int i=0;i<list.size();i++){
			System.out.println("########");
			Account ac = list.get(i);
			if(ac.getAccount_number().equals(acc2)){
				if(ac.getStatus()==1){
					if(money>as.getBalance(acc1)){
						flag = false;
						waring3 = "金额不足";
						break;
					}
					jump = true;
					break;
				}else{
					waring1 = "帐号已经冻结";
					flag = false;
					break;
				}
			}else{
				flag = true;
			}
		}
		if(flag){
			waring2 = "帐号不对";
		}
		if(jump){
		int total = as.updateBalance(acc1, acc2, money);
		request.getRequestDispatcher("turnsucc.jsp").forward(request, response);			
		}else{
			request.setAttribute("waring1",waring1);
			request.setAttribute("waring2",waring2);
			request.setAttribute("waring3",waring3);
			request.setAttribute("accname",acc2);
			request.setAttribute("money",money);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
			
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

	public void continue1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========continue1========");
		response.sendRedirect("success.jsp");
	}
	
	public void quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==========quit============");
		HttpSession  session = request.getSession();
		session.removeAttribute("accountname");
		response.sendRedirect("login.jsp");
	}
}
