package com.alyssa.onlineorder;

import com.alyssa.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Fight On!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // Hello
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + customer + "</h1>");
//        out.println("</body></html>");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);
        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // Read customer information from request body
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        String email = jsonRequest.getString("email");
//        String firstName = jsonRequest.getString("first_name");
//        String lastName = jsonRequest.getString("last_name");
//        int age = jsonRequest.getInt("age");
//        // Print customer information to IDE console
//        System.out.println("Email is: " + email);
//        System.out.println("First name is: " + firstName);
//        System.out.println("Last name is: " + lastName);
//        System.out.println("Age is: " + age);
//        // Return status = ok as response body to the client
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("status", "ok");
//        response.getWriter().print(jsonResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(request.getReader(), Customer.class);

        System.out.println("Email is:" + customer.getEmail());
        System.out.println("First name is:" +customer.getFirstName());
        System.out.println("Last name is:" + customer.getLastName());
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}