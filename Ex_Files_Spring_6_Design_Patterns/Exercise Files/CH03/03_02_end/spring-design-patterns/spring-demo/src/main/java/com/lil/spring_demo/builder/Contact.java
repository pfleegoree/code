package com.lil.spring_demo.builder;

public class Contact {

  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  private Contact(String firstName, String lastName, String emailAddress){
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public static class ContactBuilder{
    private String firstName;
    private String lastName;
    private String emailAddress;

    private ContactBuilder() {
      super();
    }

    public static ContactBuilder getInstance(){
      return new ContactBuilder();
    }

    public ContactBuilder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public ContactBuilder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public ContactBuilder setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
      return this;
    }

    public Contact build(){
      return new Contact(this.firstName, this.lastName, this.emailAddress);
    }
  }
}
