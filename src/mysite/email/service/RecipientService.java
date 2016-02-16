package mysite.email.service;

import java.io.IOException;
import java.util.LinkedList;
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

  public List<Recipient> searchRecipient(List<Recipient> recipients, String searchWord) {
    List<Recipient> searchResult = new LinkedList<Recipient>();
    for(Recipient recipient : recipients){
      String name = recipient.getName();
      if(name.equals(searchWord)){
        searchResult.add(recipient);
      }
      
      String email = recipient.getEmail();
      if(email.equals(searchWord)){
        searchResult.add(recipient);
      }
    }
    
    return searchResult;
  }

}
