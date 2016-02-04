package mysite.email;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    response.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    String title = "Register Page";
    
    printHeader(out, title);
    printForm(out);
    printFooter(out); 
  }

  private void printForm(PrintWriter out) {
    out.println("<form action=\"store\" method=\"GET\">");
    
    out.println("UserName: <input type=\"text\" name=\"username\"></br>");
    out.println("Email: <input type=\"text\" name=\"email\"></br>");
    out.println("<input type=\"submit\" value=\"store\">");
    
    out.println("</form>");
  }
  private void printHeader(PrintWriter out, String title) {
    out.println("<html>");
    out.println("<head>");
    
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
    out.println("<title>" + title + "</title>");
    
    out.println("</head>");
    out.println("<body>");
    
    
    String url = "http://localhost:8080/email/list";
    String linkName = "List Page";
    out.println("<a href=" + url + ">" + linkName + "</a>");
  }
  private void printFooter(PrintWriter out) {
    out.println("</body>");
    out.println("</html>");
  }

}
