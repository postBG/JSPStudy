package mysite.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
  RecipientStore recipientStore = new RecipientStore();
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    
    String userName = request.getParameter("username");
    String userEmail = request.getParameter("email");
    
    Recipient recipient = new Recipient(userName,userEmail);
    recipientStore.write(recipient);
    
    response.getWriter().write(userName);
    
  }
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    response.setCharacterEncoding(encoding);
    request.setCharacterEncoding(encoding);
  }
}
