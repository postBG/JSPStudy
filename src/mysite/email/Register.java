package mysite.email;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    setCharEncoding(request, response);
    Enumeration<String> parameterNames = request.getParameterNames();
    String userName = request.getParameter(parameterNames.nextElement());
    String userEmail = request.getParameter(parameterNames.nextElement());
    
    writeUserInfoAtFile(userName, userEmail);
    
    response.sendRedirect("http://localhost:8080/email/list");
  }

  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    response.setCharacterEncoding("utf-8");
    request.setCharacterEncoding("utf-8");
  }
  
  private void writeUserInfoAtFile(String userName, String userEmail) throws IOException {
    BufferedWriter userInfoPrinter = new BufferedWriter(new FileWriter("user.txt", true));

    userInfoPrinter.write(userName);
    userInfoPrinter.write(",");
    userInfoPrinter.write(userEmail);
    userInfoPrinter.newLine();
    
    userInfoPrinter.close();
  }
}
