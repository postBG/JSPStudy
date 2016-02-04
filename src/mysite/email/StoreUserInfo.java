package mysite.email;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreUserInfo extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    request.setCharacterEncoding("utf-8");
    
    //TODO: 익셉션 처리
    Enumeration<String> parameterNames = request.getParameterNames();
    String userName = request.getParameter(parameterNames.nextElement());
    String userEmail = request.getParameter(parameterNames.nextElement());
    
    writeUserInfoAtFile(userName, userEmail);
    
    response.sendRedirect("http://localhost:8080/email/list");
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
