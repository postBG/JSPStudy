package mysite.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysite.email.controller.RecipientController;
import mysite.email.dao.RecipientStore;

public class EmailServlet extends HttpServlet{
  
  RecipientController recipientController = new RecipientController();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    String pathInfo = request.getPathInfo();

    if ( pathInfo.startsWith("/list")){
      recipientController.processList(request, response);
    }
    else if( pathInfo.startsWith("/store")){
      recipientController.addRecipient(request, response);
    }
    else if( pathInfo.startsWith("/register")){
      response.sendRedirect("Register.jsp");
    }
  }

  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    request.setCharacterEncoding(encoding);
    
    String contextTypeInfo = "text/html;charset=" + encoding;
    response.setContentType(contextTypeInfo);
  }
 
}
