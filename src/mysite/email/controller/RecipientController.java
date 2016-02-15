package mysite.email.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysite.email.dao.RecipientStore;
import mysite.email.model.Recipient;
import mysite.email.service.RecipientService;

public class RecipientController {
  private RecipientService recipientService;

  public RecipientController() {
    this.recipientService = new RecipientService();
  }

  public void processList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Recipient> recipients = recipientService.list();
    request.setAttribute("recipients", recipients);
    forwardUserInfoListToView(request, response);
  }

  void forwardUserInfoListToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("ListUp.jsp");
    rd.forward(request, response);
  }

  public void addRecipient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    Recipient recipient = new Recipient(name,email);
     
    String message = "";
    if( recipientService.hasDuplicatedEmail(recipient) ){
      message = "이미 존재하는 이메일 주소입니다.";
    }
    else {
      recipientService.addRecipient(recipient);
    
      message = name + "님의 정보를 성공적으로 저장했습니다.";
    }
    request.setAttribute("message", message);
    RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
    rd.forward(request, response);
  }
}