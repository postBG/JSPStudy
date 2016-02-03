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
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    out = response.getWriter();
    printHeader();
    
    //printGetterInfo("getAsyncContext()", request.getAsyncContext());
    /*Enumeration<String> attributeNames = request.getAttributeNames();
    while(attributeNames.hasMoreElements()){
      printGetterInfo("getAttribute(String arg0)", request.getAttribute(attributeNames.nextElement()));
    }
    */
    printGetterInfo("getAuthType()", request.getAuthType());
    
    printGetterInfo("getCharacterEncoding()", request.getCharacterEncoding());
    //printGetterInfo("getClass()", request.getClass());
    //printGetterInfo("getContentLength()", request.getContentLength());
    //printGetterInfo("getContentLengthLong()", request.getContentLengthLong());
    printGetterInfo("getContentType()", request.getContentType());
    printGetterInfo("getContextPath()", request.getContextPath());
    //printGetterInfo("getCookies()", request.getCookies());
    
    //printGetterInfo("getDateHeader(String arg0)", request.getDateHeader(null));
    //printGetterInfo("getDispatcherType()", request.getDispatcherType());
  
    printGetterInfo("getHeader(String arg0)", request.getHeader("hello"));
    //printGetterInfo("getHeaderNames()", request.getHeaderNames());
    //printGetterInfo("getHeaders(String arg0)", request.getHeaders(null));
    
    //printGetterInfo("getInputStream()", request.getInputStream());
    //printGetterInfo("getIntHeader(String arg0)", request.getIntHeader(null));
    
    printGetterInfo("getLocalAddr()", request.getLocalAddr());
    //printGetterInfo("getLocale()", request.getLocale());
    //printGetterInfo("getLocales()", request.getLocales());
    printGetterInfo("getLocalName()", request.getLocalName());
    //printGetterInfo("getLocalPort()", request.getLocalPort());

    printGetterInfo("getMethod()", request.getMethod());
    
    printGetterInfo("getParameter(String arg0)", request.getParameter(null));
    //printGetterInfo("getParameterMap()", request.getParameterMap());
    //printGetterInfo("getParameterNames()", request.getParameterNames());
    //printGetterInfo("getParameterValues(String arg0)", request.getParameterValues(null));
    //printGetterInfo("getPart(String arg0)", request.getPart(null));
    printGetterInfo("getPathInfo()", request.getPathInfo());
    printGetterInfo("getPathTranslated()", request.getPathTranslated());
 
    printGetterInfo("getQueryString()", request.getQueryString());
    
    //printGetterInfo("getReader()", request.getReader());
    printGetterInfo("getRemoteAddr()", request.getRemoteAddr());
    printGetterInfo("getRemoteHost()", request.getRemoteHost());
    //printGetterInfo("getRemotePort()", request.getRemotePort());
    printGetterInfo("getRemoteUser()", request.getRemoteUser());
    //printGetterInfo("getRequestDispatcher(String arg0)", request.getRequestDispatcher(null));
    printGetterInfo("getRequestedSessionId()", request.getRequestedSessionId());
    printGetterInfo("getRequestURI()", request.getRequestURI());
    //printGetterInfo("getRequestURL()", request.getRequestURL());
    
    printGetterInfo("getScheme()", request.getScheme());
    printGetterInfo("getServerName()", request.getServerName());
    
    printFooter();
  }
  private void printHeader(){
    out.println("<html>");
    out.println("<head><title>Print All Request Getter function</title></head>");
    out.println("<body>");
    
    out.println("<table>");
  }
  private void printGetterInfo(String functionName, String output){
    out.println("<tr>");
    out.println("<td>" + functionName + "</td>");
    out.println("<td>" + output + "</td>");
    out.println("</tr>");
  }
  private void printFooter(){
    out.println("</table>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
