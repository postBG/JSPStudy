package mysite.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
  RecipientStore recipientStore = new RecipientStore();
  private static final int ERROR = 1;
  private static final int OK = 0;
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    Recipient recipient = new Recipient(name,email);
    
    if(validateEmail(recipient) == ERROR){
      response.getWriter().write("이미 존재하는 이메일 주소입니다.");
      return;
    }
    
    recipientStore.write(recipient);
    
    response.getWriter().write(name + "님의 정보를 성공적으로 저장했습니다.");
  }
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    response.setCharacterEncoding(encoding);
    request.setCharacterEncoding(encoding);
  }
  private int validateEmail(Recipient newRecipient){
    List<Recipient> recipients = RecipientStore.list();
    
    for(Recipient recipient : recipients){
      String storedEmail = recipient.getEmail();
      if(storedEmail.equals(newRecipient.getEmail())){
        return ERROR;
      }
    }
    
    return OK;
  }
}
