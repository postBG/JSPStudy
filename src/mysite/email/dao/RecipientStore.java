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

  private static final String RECIPIENT_FILENAME = "C:\\Users\\postBG\\Documents\\workspace-sts-3.7.2.RELEASE\\email\\WebContent\\data\\user.txt";
  private static final String FIELD_DELIMITER = ",";
  
  public List<Recipient> list() {
    BufferedReader in = null;
    List<Recipient> recipients = new LinkedList<Recipient>();
    
    try {
      in = new BufferedReader(new FileReader(RECIPIENT_FILENAME));
      return makeRecipientList(in, recipients);
      
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

  List<Recipient> makeRecipientList(BufferedReader in, List<Recipient> recipients) throws IOException {
    String record;
    while((record = in.readLine()) != null){
      String[] fields = record.split(FIELD_DELIMITER);
      Recipient recipient = new Recipient(fields[0], fields[1]);
      
      recipients.add(recipient);
    }
    
    return recipients;
  }
  
  public void write(Recipient recipient) throws IOException {
    FileWriter fileWriter = new FileWriter(RECIPIENT_FILENAME, true);
    BufferedWriter recipientInfoPrinter = new BufferedWriter(fileWriter);
  
    wrtieRecipient(recipientInfoPrinter, recipient);
  }

  void wrtieRecipient(BufferedWriter recipientInfoPrinter, Recipient recipient) throws IOException {
    recipientInfoPrinter.append(recipient.getName() + FIELD_DELIMITER + recipient.getEmail());
    recipientInfoPrinter.newLine();
    recipientInfoPrinter.close();
  }

}
