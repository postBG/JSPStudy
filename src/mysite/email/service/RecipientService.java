package mysite.email.service;

import java.io.IOException;
import java.util.List;

import mysite.email.dao.RecipientStore;
import mysite.email.model.Recipient;

public class RecipientService {
  RecipientStore recipientStore = new RecipientStore();

  RecipientStore getRecipientStore() {
    return recipientStore;
  }

  public void addRecipient(Recipient recipient) throws IOException {
    recipientStore.write(recipient);
  }

  public boolean hasDuplicatedEmail(Recipient newRecipient){
    List<Recipient> recipients = recipientStore.list();

    for(Recipient recipient : recipients){
      String storedEmail = recipient.getEmail();
      if(storedEmail.equals(newRecipient.getEmail())){
        return true;
      }
    }
    
    return false;
  }

  public List<Recipient> list() {
    return recipientStore.list();
  }

}
