package mysite.email;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreUserInfo extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    PrintWriter out = response.getWriter();
    String title = "Store";
    
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
