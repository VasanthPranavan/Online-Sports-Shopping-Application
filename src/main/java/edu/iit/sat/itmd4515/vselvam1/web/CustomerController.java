/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.CustomerPojo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author Vasanth Pranavan
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/customer"})
public class CustomerController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());

    @Resource(lookup = "jdbc/itmd4515DS")
    DataSource ds;

    @Resource
    Validator validator;

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/world?zeroDateTimeBehavior=convertToNull";
        String username = "itmd4515";
        String pass = "itmd4515";

        return DriverManager.getConnection(jdbcUrl, username, pass);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("inside get");
        CustomerPojo customer = new CustomerPojo();
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/newCustomer.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOG.info("inside post");

        String cusFName = request.getParameter("fName");
        String cusLName = request.getParameter("lName");
        String ageParam = request.getParameter("age");
        String cusMail = request.getParameter("mail");
        Integer cusAge = null;
        LOG.info("you have passed a First Name of " + cusFName);
        LOG.info("you have passed a Last Name of " + cusLName);
        if (ageParam != null & !(ageParam.isEmpty())) {
            cusAge = Integer.parseInt(request.getParameter("age"));
            LOG.info("you have passed age of " + cusAge);
        }
        LOG.info("you have passed a Mail: " + cusMail);

        CustomerPojo customer = new CustomerPojo(cusFName, cusLName, cusAge, cusMail);
        LOG.info("My POJO " + customer.toString());

        //Set<ConstraintViolation<Customer>> constraintViolations1 = validator.validate(customer);
        //int a= constraintViolations1.size();
        //String name=Integer.toString(a);
        // LOG.info("size of  Contraint Vioaltion is "+name);
        Set<ConstraintViolation<CustomerPojo>> contraintViolations = validator.validate(customer);
        if (contraintViolations.size() > 0) {
            LOG.info("Problem occured during Validting POJO");
            for (ConstraintViolation<CustomerPojo> bad : contraintViolations) {
                LOG.info(bad.getPropertyPath() + " " + bad.getMessage());
            }
            request.setAttribute("customer", customer);
            request.setAttribute("mistakes", contraintViolations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/newCustomer.jsp");
            dispatcher.forward(request, response);

        } else {
            try (Connection c = ds.getConnection();
                    PreparedStatement ps = c.prepareStatement("insert into customers " + "(fname,lname,age,mail)" + "VALUES(?,?,?,?)");) {

                ps.setString(1, customer.getfName());
                ps.setString(2, customer.getlName());
                ps.setInt(3, customer.getAge());
                ps.setString(4, customer.getMail());
                ps.executeUpdate();
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }

            LOG.info("We dont have any issues with Validting POJO. You may proceed");
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customerconfirm.jsp");
            dispatcher.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
