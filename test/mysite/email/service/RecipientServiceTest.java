package mysite.email.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mysite.email.model.Recipient;

public class RecipientServiceTest {
  
  private RecipientService recipientService;
  private List<Recipient> recipients;

  @Before
  public void setUp(){
    recipientService = new RecipientService();
    recipients = recipientService.list();
  }  
  
  @Test
  public void noRecipientTestByName() {
    assertTrue(recipientService.searchRecipient(recipients , "테스트를 위한 이름").isEmpty());
  }

  @Test
  public void noRecipientTestByEmail() {
    assertTrue(recipientService.searchRecipient(recipients, "테스트를 위한 이메일").isEmpty());
  }
  
  @Test
  public void oneResultTestByName() {
    Recipient recipient = recipientService.searchRecipient(recipients , "꽁꽁").get(0);
    assertEquals("꽁꽁", recipient.getName());
    assertEquals("qwerr", recipient.getEmail());
  }
  
  @Test
  public void oneResultTestByEmail() {
    assertTrue(recipientService.searchRecipient(recipients , "kkk").isEmpty());
  }
  
  @Test
  public void twoResultTestByName() {
    List<Recipient> searchResult = recipientService.searchRecipient(recipients , "무민");
    
    Recipient recipient1 = searchResult.get(0);
    assertEquals("무민", recipient1.getName());
    assertEquals("wierr", recipient1.getEmail());
    
    Recipient recipient2 = searchResult.get(1);
    assertEquals("무민", recipient2.getName());
    assertEquals("eooeis", recipient2.getEmail());
  }

}
