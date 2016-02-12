package mysite.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserInfo extends HttpServlet{
  
  RecipientStore recipientStore = new RecipientStore();
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    List<Recipient> userInfoList = recipientStore.list();
    forwardUserInfoListToView(request, response, userInfoList);
  }
  
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    request.setCharacterEncoding(encoding);
    
    String contextTypeInfo = "text/html;charset=" + encoding;
    response.setContentType(contextTypeInfo);
  }
  
  private void forwardUserInfoListToView(HttpServletRequest request, HttpServletResponse response, List<Recipient> recipients) throws ServletException, IOException {
    request.setAttribute("recipients", recipients);
    RequestDispatcher rd = request.getRequestDispatcher("ListUp.jsp");
    rd.forward(request, response);
  }
 
}
