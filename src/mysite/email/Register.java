package mysite.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysite.email.controller.RecipientController;
import mysite.email.service.RecipientService;

public class Register extends HttpServlet{
  RecipientController recipientController = new RecipientController();
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    
    recipientController.addRecipient(request, response);    
  }

  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    response.setCharacterEncoding(encoding);
    request.setCharacterEncoding(encoding);
  }
}
