package mysite.email.dao;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mysite.email.model.Recipient;

public class RecipientStoreTest {
  private RecipientStore recipientStore;
  private BufferedReader in = null;
  private BufferedWriter out = null;
  private List<Recipient> recipients;
  private StringWriter stringWriter;
  private String lineSeparator;
  
  @Before
  public void writeTestSetUp(){
    recipientStore = new RecipientStore();
    recipients = new LinkedList<Recipient>();
    lineSeparator = System.lineSeparator();
  }
  
  @Before
  public void readTestSetUp(){
    stringWriter = new StringWriter();
  }
  
  @Test
  public void 비어있는_파일_읽기() throws IOException {
    String fileContents = "";
    in = new BufferedReader(new StringReader(fileContents));

    recipients = recipientStore.makeRecipientList(in, recipients);
    assertEquals(0, recipients.size());
  }
  
  @Test
  public void 한줄짜리_파일을_읽으면_한명의_recipient가_있어야함() throws IOException {
    String fileContents = "홍길동,run";
    in = new BufferedReader(new StringReader(fileContents));

    recipients = recipientStore.makeRecipientList(in, recipients);
    assertEquals(1, recipients.size());
    assertEquals("홍길동", recipients.get(0).getName());
    assertEquals("run", recipients.get(0).getEmail());
  }

  @Test
  public void 한줄짜리_파일을_읽으면_recipient의_정보가_잘_담겨있어야함() throws IOException {
    String fileContents = "홍길동,run";
    in = new BufferedReader(new StringReader(fileContents));

    recipients = recipientStore.makeRecipientList(in, recipients);
    assertEquals("홍길동", recipients.get(0).getName());
    assertEquals("run", recipients.get(0).getEmail());
  }

  
  @Test
  public void 두줄짜리_파일을_읽으면_크기가_2여야함() throws IOException {
    String fileContents = "홍길동,run\n셜록홈즈,deduce\n";
    in = new BufferedReader(new StringReader(fileContents));

    recipients = recipientStore.makeRecipientList(in, recipients);
    assertEquals(2, recipients.size());
  }

  @Test
  public void 두줄짜리_파일을_읽으면_recipient의_정보가_잘_들어있어야함() throws IOException {
    String fileContents = "홍길동,run\n셜록홈즈,deduce\n";
    in = new BufferedReader(new StringReader(fileContents));

    recipients = recipientStore.makeRecipientList(in, recipients);
    assertEquals("홍길동", recipients.get(0).getName());
    assertEquals("run", recipients.get(0).getEmail());
    
    assertEquals("셜록홈즈", recipients.get(1).getName());
    assertEquals("deduce", recipients.get(1).getEmail());
  }

  @Test
  public void 파일에_recipient를_한명_쓰기() throws IOException{
    Recipient recipient = new Recipient("홍길동", "steal");
    
    makeReadStream();
    recipientStore.wrtieRecipient(out, recipient);
    assertEquals("홍길동,steal" + lineSeparator, stringWriter.toString()); 
  }
  
  @Test
  public void 파일에_recipient를_두명_쓰기() throws IOException{
    Recipient recipient1 = new Recipient("홍길동", "steal");
    Recipient recipient2 = new Recipient("셜록홈즈", "deduce");
    
    makeReadStream();
    recipientStore.wrtieRecipient(out, recipient1);
    
    makeReadStream();
    recipientStore.wrtieRecipient(out, recipient2);
    assertEquals("홍길동,steal" + lineSeparator + "셜록홈즈,deduce" + lineSeparator, stringWriter.toString()); 
  }

  private void makeReadStream(){
    out = new BufferedWriter(stringWriter);
  }
  
  @After
  public void cleanUp(){
    if(in != null){
      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    if(out != null){
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
