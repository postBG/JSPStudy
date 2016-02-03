package mysite.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hundred extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>Sum of 1 to 100</title></head>");
    out.println("<body>");
    int total = 0;
    for(int cnt = 1; cnt <= 100; cnt++){
      total += cnt;
    }
    
    out.println("1 + 2 + 3 + ... + 100 = " + total);
    out.println("</body>");
    out.println("</html>"); 
  }
 
}

