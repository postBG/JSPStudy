package mysite.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserInfo extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException{
    setCharEncoding(request, response);
    
    List<String[]> userInfoList = listUpUserInfo();
    request.setAttribute("UserInfoList", userInfoList);
    RequestDispatcher rd = request.getRequestDispatcher("ListUp.jsp");
    rd.forward(request, response);
  }
  private static List<String[]> listUpUserInfo(){
    try {
      return parseAndPrintUserInfo();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  private static List<String[]> parseAndPrintUserInfo() throws FileNotFoundException, IOException {
    BufferedReader in = new BufferedReader(new FileReader("user.txt"));
    
    List<String[]> userInfoList = new LinkedList<String[]>();
    String unparsedUserInfo;
    String[] parsedUserInfo;
    while((unparsedUserInfo = in.readLine()) != null){
      parsedUserInfo = unparsedUserInfo.split(",");
      userInfoList.add(parsedUserInfo);
    }
    
    in.close();
    return userInfoList;
  }
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
  }
 
}
