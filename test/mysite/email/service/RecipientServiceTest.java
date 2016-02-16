package mysite.email.service;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mysite.email.dao.RecipientStore;
import mysite.email.model.Recipient;

public class RecipientServiceTest {
  
  private RecipientService recipientService;

  @Before
  public void setUp(){
    recipientService = new RecipientService();
    RecipientStore recipientStore = new RecipientStore() {
      @Override
      public List<Recipient> list() {
        List<Recipient> recipients = new LinkedList<Recipient>();
        recipients.add(new Recipient("꽁꽁", "qwerr"));
        recipients.add(new Recipient("무민", "wierr"));
        recipients.add(new Recipient("무민", "eooeis"));
        
        return recipients;
      }
    };
    
    recipientService.setRecipientStore(recipientStore);
  }  
  
  @Test
  public void noRecipientTestByName() {
    assertTrue(recipientService.searchRecipient("테스트를 위한 이름").isEmpty());
  }

  @Test
  public void noRecipientTestByEmail() {
    assertTrue(recipientService.searchRecipient("테스트를 위한 이메일").isEmpty());
  }
  
  @Test
  public void oneResultTestByName() {
    Recipient recipient = recipientService.searchRecipient("꽁꽁").get(0);
    assertEquals("꽁꽁", recipient.getName());
    assertEquals("qwerr", recipient.getEmail());
  }
  
  @Test
  public void oneResultTestByEmail() {
    assertTrue(recipientService.searchRecipient("kkk").isEmpty());
  }
  
  @Test
  public void twoResultTestByName() {
    List<Recipient> searchResult = recipientService.searchRecipient("무민");
    
    Recipient recipient1 = searchResult.get(0);
    assertEquals("무민", recipient1.getName());
    assertEquals("wierr", recipient1.getEmail());
    
    Recipient recipient2 = searchResult.get(1);
    assertEquals("무민", recipient2.getName());
    assertEquals("eooeis", recipient2.getEmail());
  }
  
  @Test
  public void falseWhenNoDuplicate(){
    assertFalse(recipientService.hasDuplicatedEmail(new Recipient("없는 이름", "없는 이메일")));
  }
  
  @Test
  public void trueWhenDuplicate(){
    assertTrue(recipientService.hasDuplicatedEmail(new Recipient("없는 이름", "qwerr")));
  }
}
