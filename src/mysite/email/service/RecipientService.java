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

  public List<Recipient> searchRecipient(String searchWord) {
    List<Recipient> searchResult = new LinkedList<Recipient>();
    List<Recipient> recipients = recipientStore.list();
    
    for(Recipient recipient : recipients){
      if(recipient.getName().equals(searchWord)){
        searchResult.add(recipient);
      }
      
      if(recipient.getEmail().equals(searchWord)){
        searchResult.add(recipient);
      }
    }
    
    return searchResult;
  }

  public void setRecipientStore(RecipientStore recipientStore) {
    this.recipientStore = recipientStore;
  }

}
