package mysite.email.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import mysite.email.model.Recipient;

public class RecipientStore {

  private static final String RECIPIENT_FILENAME = "C:\\Users\\postBG\\Desktop\\sts-bundle\\sts-3.7.2.RELEASE\\user.txt";
  private static final String FIELD_DELIMITER = ",";
  
  public List<Recipient> list() {
    BufferedReader in = null;
    List<Recipient> recipients = new LinkedList<Recipient>();
    
    try {
      String record;
      
      in = new BufferedReader(new FileReader(RECIPIENT_FILENAME));
      
      while((record = in.readLine()) != null){
        String[] fields = record.split(FIELD_DELIMITER);
        Recipient recipient = new Recipient(fields[0], fields[1]);
        
        recipients.add(recipient);
      }
      
      return recipients;
      
    } catch (FileNotFoundException e) {
      
      e.printStackTrace();
      
    } catch (IOException e) {
      
      e.printStackTrace();
      
    } finally {
      if ( in != null ) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    return recipients;
  }
  
  public void write(Recipient recipient) throws IOException {
    BufferedWriter recipientInfoPrinter = new BufferedWriter(new FileWriter(RECIPIENT_FILENAME, true));
  
    recipientInfoPrinter.write(recipient.getName() + FIELD_DELIMITER + recipient.getEmail());
    recipientInfoPrinter.newLine();
    
    recipientInfoPrinter.close();
  }
  
}
