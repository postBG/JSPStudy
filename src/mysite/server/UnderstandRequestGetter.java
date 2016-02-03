package mysite.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnderstandRequestGetter extends HttpServlet {
  private PrintWriter out;
  private String formattedFunctionName;
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    out = response.getWriter();
    printHeader();
    
    printGetterInfo("getAuthType()", request.getAuthType());
    
    printGetterInfo("getCharacterEncoding()", request.getCharacterEncoding());
    printGetterInfo("getContentLength()", request.getContentLength());
    printGetterInfo("getContentType()", request.getContentType());
    printGetterInfo("getContextPath()", request.getContextPath());
    
  
    Enumeration<String> headerNames = request.getHeaderNames();
    String headerName;
    while(headerNames.hasMoreElements()){
      headerName = headerNames.nextElement();
      formattedFunctionName = "getHeader(" + headerName + ")";
      printGetterInfo(formattedFunctionName , request.getHeader(headerName));
    }
    
    
    printGetterInfo("getLocalAddr()", request.getLocalAddr());
    printGetterInfo("getLocalName()", request.getLocalName());
    printGetterInfo("getLocalPort()", request.getLocalPort());

    printGetterInfo("getMethod()", request.getMethod());
    
    Enumeration<String> parameterNames = request.getParameterNames();
    String parameterName;
    while(parameterNames.hasMoreElements()){
      parameterName = parameterNames.nextElement();
      formattedFunctionName = "getParameter(" + parameterName + ")";
      printGetterInfo(formattedFunctionName, request.getParameter(parameterName));      
    }
    printGetterInfo("getPathInfo()", request.getPathInfo());
    printGetterInfo("getPathTranslated()", request.getPathTranslated());
 
    printGetterInfo("getQueryString()", request.getQueryString());
    
    printGetterInfo("getRemoteAddr()", request.getRemoteAddr());
    printGetterInfo("getRemoteHost()", request.getRemoteHost());
    printGetterInfo("getRemotePort()", request.getRemotePort());
    printGetterInfo("getRemoteUser()", request.getRemoteUser());
    printGetterInfo("getRequestedSessionId()", request.getRequestedSessionId());
    printGetterInfo("getRequestURI()", request.getRequestURI());
    printGetterInfo("getRequestURL()", request.getRequestURL());
    
    printGetterInfo("getScheme()", request.getScheme());
    printGetterInfo("getServerName()", request.getServerName());
    printGetterInfo("getDateHeader(String arg0)", request.getDateHeader(null));

    //printGetterInfo("getCookies()", request.getCookies());

    //printGetterInfo("getPart(String arg0)", request.getPart(null));
    //printGetterInfo("getRequestDispatcher(String arg0)", request.getRequestDispatcher(null));
    //printGetterInfo("getAsyncContext()", request.getAsyncContext());
    //printGetterInfo("getClass()", request.getClass());
    //printGetterInfo("getDispatcherType()", request.getDispatcherType());
    //printGetterInfo("getInputStream()", request.getInputStream());
    //printGetterInfo("getLocale()", request.getLocale());
    //printGetterInfo("getLocales()", request.getLocales());
    
    printFooter();
  }
  
  private void printHeader(){
    out.println("<html>");
    out.println("<head><title>Print All Request Getter function</title></head>");
    out.println("<body>");
    
    out.println("<table>");
  }
  private void printFooter(){
    out.println("</table>");
    
    out.println("</body>");
    out.println("</html>");
  }
  private void printGetterInfo(String functionName, String output){
    out.println("<tr>");
    out.println("<td>" + functionName + "</td>");
    out.println("<td>" + output + "</td>");
    out.println("</tr>");
  }
  private void printGetterInfo(String functionName, StringBuffer output){
    out.println("<tr>");
    out.println("<td>" + functionName + "</td>");
    out.println("<td>" + output.toString() + "</td>");
    out.println("</tr>");
  }
  private void printGetterInfo(String functionName, int output){
    out.println("<tr>");
    out.println("<td>" + functionName + "</td>");
    out.println("<td>" + output + "</td>");
    out.println("</tr>");
  }
  private void printGetterInfo(String functionName, long output) {
    out.println("<tr>");
    out.println("<td>" + functionName + "</td>");
    out.println("<td>" + output + "</td>");
    out.println("</tr>");
  }
}
