package mysite.email;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreUserInfo extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    request.setCharacterEncoding("euc-kr");
    PrintWriter out = response.getWriter();
    String title = "Store";

    Enumeration<String> parameterNames = request.getParameterNames();
    String userName = request.getParameter(parameterNames.nextElement());
    String userEmail = request.getParameter(parameterNames.nextElement());
    
    BufferedWriter userInfoPrinter = new BufferedWriter(new FileWriter("user.txt", true));

    userInfoPrinter.write(userName);
    userInfoPrinter.write(",");
    userInfoPrinter.write(userEmail);
    userInfoPrinter.newLine();
    
    userInfoPrinter.close();
    
    printHeader(out, title);
    
    out.println("hello");
    
    printFooter(out); 
  }

  private void printFooter(PrintWriter out) {
    out.println("</body>");
    out.println("</html>");
  }

  private void printHeader(PrintWriter out, String title) {
    out.println("<html>");
    out.println("<head><title>" + title + "</title></head>");
    out.println("<body>");
  }
}
