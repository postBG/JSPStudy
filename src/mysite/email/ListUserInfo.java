package mysite.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserInfo extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    setCharEncoding(request, response);
    
    PrintWriter out = response.getWriter();
    String title = "List User Information";
    
    printHeader(out, title);
    listUpUserInfo(out);
    printFooter(out); 
  }
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
  }
  private void printHeader(PrintWriter out, String title) {
    printDocumentHeader(out, title);
    printTableHeader(out);
  }
  private void printDocumentHeader(PrintWriter out, String title) {
    out.println("<html>");
    out.println("<head>");
    
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
    out.println("<title>" + title + "</title>");
    
    out.println("</head>");
    out.println("<body>");
    
    String url = "http://localhost:8080/email/register";
    String linkName = "Register Page";
    out.println("<a href=" + url + ">" + linkName + "</a>");
  }
  private void printTableHeader(PrintWriter out){
    out.println("<table>");
    out.println("<tr>");
    
    out.println("<th>이름</th>");
    out.println("<th>Email</th>");
    
    out.println("</tr>");
  }
  private void printFooter(PrintWriter out) {
    printTableFooter(out);
    printDocumentFooter(out);
  }
  private void printDocumentFooter(PrintWriter out) {
    out.println("</body>");
    out.println("</html>");
  }
  private void printTableFooter(PrintWriter out){
    out.println("</table>");
  }
  private void listUpUserInfo(PrintWriter out){
    try {
      parseAndPrintUserInfo(out);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void parseAndPrintUserInfo(PrintWriter out) throws FileNotFoundException, IOException {
    BufferedReader in = new BufferedReader(new FileReader("user.txt"));
    
    String unparsedUserInfo;
    String[] parsedUserInfo;
    while((unparsedUserInfo = in.readLine()) != null){
      parsedUserInfo = unparsedUserInfo.split(",");
      printOneUserInfo(out, parsedUserInfo);
    }
    
    in.close();
  }
  private void printOneUserInfo(PrintWriter out, String[] parsedUserInfo) {
    out.println("<tr>");
    out.println("<td>" + parsedUserInfo[0] + "</td>");
    out.println("<td>" + parsedUserInfo[1] + "</td>");
    out.println("</tr>");
  }
 
}
