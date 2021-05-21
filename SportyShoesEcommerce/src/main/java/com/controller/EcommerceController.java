package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Products;
import com.beans.Sales;
import com.beans.Users;
import com.service.ProductRepository;
import com.service.SalesRepository;
import com.service.UserValidity;


@RestController
public class EcommerceController {
	private String password = "Admin";
	
	@Autowired
	private UserValidity userValidity;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SalesRepository salesRepository;
	
	@GetMapping("/")
	public void home2(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.sendRedirect("index.jsp");
	}
	
	@GetMapping("/home")
	public void home(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.sendRedirect("index.jsp");
	}
	
	@PostMapping("/usersignup")
	public void usersignup(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		
		String userName = req.getParameter("signupName");
		String userPass = req.getParameter("signupPass");
		String email = req.getParameter("signupEmail");
		String city = req.getParameter("signupCity");
		
		userValidity.addusers(userName, userPass, email, city);
		System.out.println("Sign up deatils added");
		res.sendRedirect("userlogin.jsp");
	}
	
	
	@PostMapping("/validateuser")
	public void validateuser(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		
		String userName = req.getParameter("uName");
		String userPass = req.getParameter("pwd");
		
		boolean isValidUser = userValidity.validateusers(userName, userPass);
		
		if (!isValidUser) {
			RequestDispatcher rd = req.getRequestDispatcher("userlogin.jsp");
			PrintWriter out = res.getWriter();
			rd.include(req, res);
			out.println("<br/> <centre> <span style = 'color:red'> Please Login again with valid USER credentials </span> </centre>");
		}
		else {
			HttpSession indi=req.getSession();
			indi.setAttribute("username", userName);
			System.out.println("username updated in session");
			res.sendRedirect("product.jsp");
		}

	}
	
	@GetMapping("/listuser")
	public void getuserlist (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("manageUser.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		List<Users> listusers = userValidity.listUsers();
		if (listusers.isEmpty()) {
			out.println("<br/> <centre> <span style = 'color:red'> NO USERS Presents </span> </centre>");
        }
		else {
			for (Users user: listusers) {
				out.println(" <br/> Name:" + user.getName() + " | Email: " + user.getEmail() + " | City " + user.getCity());	
			}

		}
	}
	
	@GetMapping("/searchuser")
	public void searchuser (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		String userName = req.getParameter("uName");
		RequestDispatcher rd = req.getRequestDispatcher("manageUser.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		Optional<Users> user = userValidity.searchusers(userName);
		if (user.isEmpty()) {
			out.println("<br/> <centre> <span style = 'color:red'> Searched USERS not present </span> </centre>");
        }
		else {
			out.println(" <br/> Name:" + user.get().getName() + " | Email: " + user.get().getEmail() + " | City " + user.get().getCity());	
		}
	}
	
	
	
	
	
	@PostMapping("/adminlogin")
	public void validateLogin(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		
		String adminName = req.getParameter("adminName");
		String adminPass = req.getParameter("adminPass");
		
		if(adminName.equalsIgnoreCase("Admin") && adminPass.equalsIgnoreCase(password))
		{
			res.sendRedirect("adminhome.jsp");
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("adminlogin.jsp");
			PrintWriter out = res.getWriter();
			rd.include(req, res);
			out.println("<br/> <centre> <span style = 'color:red'> Please Login again with valid ADMIN credentials </span> </centre>");
		}

	}

	
	@PostMapping("/changePass")
	public void changePass(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		
		String newPass = req.getParameter("newPass");
		password = newPass;

		RequestDispatcher rd = req.getRequestDispatcher("adminlogin.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		out.println("<br/> <centre> <span style = 'color:blue'> PPassword Changed Successfully </span> </centre>");
	

	}
	
	
	@PostMapping("/addProduct")
	public void addProduct(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		
		String item = req.getParameter("item");
		String category = req.getParameter("category");
		int price = Integer.parseInt(req.getParameter("price"));
		System.out.println(item +"  " + category +"  " + price);
		productRepository.addProduct(item, category, price);
		RequestDispatcher rd = req.getRequestDispatcher("manageProduct.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		out.println("<br/> <centre> <span style = 'color:blue'> Product Details added Successfully </span> </centre>");
	}
	
		
	@GetMapping("/listProduct")
	public void listProduct (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("manageProduct.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		List<Products> listProducts = productRepository.listProducts();
		if (listProducts.isEmpty()) {
			out.println("<br/> <centre> <span style = 'color:red'> NO PRODUCT at Presents </span> </centre>");
        }
		else {
			for (Products product: listProducts) {
				out.println(" <br/> Item ID: " + product.getId() + " | Item Description: " + product.getItem() + " | Category: " + product.getCategory() + " | Price " + product.getPrice() );	
			}

		}
	}
	
	@PostMapping("/deleteProduct")
	public void deleteProduct (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		int id = Integer.parseInt(req.getParameter("productid"));
		RequestDispatcher rd = req.getRequestDispatcher("manageProduct.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		boolean del = productRepository.deleteProduct(id) ;
		if (del == true) {
			out.println("<br/> <centre> <span style = 'color:red'> Product Item Deleted Successfully </span> </centre>");
        }
		else {
			out.println("<br/> <centre> <span style = 'color:red'> Product Item NOT Found </span> </centre>");
		}
	}
	
	
	@PostMapping("/salesProduct")
	public void salesProduct(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		HttpSession indi=req.getSession();
		String username = (String) indi.getAttribute("username");
		int id = Integer.parseInt(req.getParameter("id"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		Date saledate = c.getTime();
		System.out.println(saledate);
		salesRepository.addSales(username, id, saledate); 
		RequestDispatcher rd = req.getRequestDispatcher("product.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		out.println("<br/> <centre> <span style = 'color:blue'> Product Sold Successfully </span> </centre>");
	}
	
		
	
	@GetMapping("/salesReport")
	public void salesReport (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException, ParseException 
	{
		String item = req.getParameter("filter");
		String details = req.getParameter("details");
		RequestDispatcher rd = req.getRequestDispatcher("salesReport.jsp");
		PrintWriter out = res.getWriter();
		rd.include(req, res);
		List<Sales> listSales = salesRepository.listSales();
		
		if (listSales.isEmpty()) {
			out.println("<br/> <centre> <span style = 'color:red'> NO Sales at Presents </span> </centre>");
        }
		else {

			for (Sales sale: listSales) {
				System.out.println(details + " 00:00:00.0");
				System.out.println("Actual date: "+ sale.getSaledate());
				if (item.equalsIgnoreCase("category") && sale.getCategory().equalsIgnoreCase(details)) {
					out.println(" <br/> Sales ID: " + sale.getSalesid() + " | Item Description: " + sale.getItem() + " | Category: " + sale.getCategory() + " | Price " + sale.getPrice() + " | Date " + sale.getSaledate());
				}
				else if (item.equalsIgnoreCase("date")){
					if (sale.getSaledate().equals(details + " 00:00:00.0")) {
						out.println(" <br/> Sales ID: " + sale.getSalesid() + " | Item Description: " + sale.getItem() + " | Category: " + sale.getCategory() + " | Price " + sale.getPrice() + " | Date " + sale.getSaledate());
					}		
				}
				else if (item.equalsIgnoreCase("all")) {
					out.println(" <br/> Sales ID: " + sale.getSalesid() + " | Item Description: " + sale.getItem() + " | Category: " + sale.getCategory() + " | Price " + sale.getPrice() + " | Date " + sale.getSaledate());		
				}
				
			}

		}
	}
	
	
}
