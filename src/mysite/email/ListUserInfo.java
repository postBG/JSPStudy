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
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    setCharEncoding(request, response, "utf-8");
    List<String[]> userInfoList = listUpUserInfo();
    forwardUserInfoListToView(request, response, userInfoList);
  }
  
  private void setCharEncoding(HttpServletRequest request, HttpServletResponse response, String encoding) throws UnsupportedEncodingException {
    request.setCharacterEncoding(encoding);
    
    String contextTypeInfo = "text/html;charset=" + encoding;
    response.setContentType(contextTypeInfo);
  }
  private void forwardUserInfoListToView(HttpServletRequest request, HttpServletResponse response, List<String[]> userInfoList) throws ServletException, IOException {
    request.setAttribute("UserInfoList", userInfoList);
    RequestDispatcher rd = request.getRequestDispatcher("ListUp.jsp");
    rd.forward(request, response);
  }
  private static List<String[]> listUpUserInfo(){
    try {
      return makeUserInfoListFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  private static List<String[]> makeUserInfoListFromFile() throws FileNotFoundException, IOException {
    List<String[]> userInfoList = new LinkedList<String[]>();
    String unparsedUserInfo;
    String[] parsedUserInfo;

    BufferedReader in = new BufferedReader(new FileReader("user.txt"));
    while((unparsedUserInfo = in.readLine()) != null){
      parsedUserInfo = unparsedUserInfo.split(",");
      userInfoList.add(parsedUserInfo);
    }
    in.close();
    
    return userInfoList;
  }
  
 
}
