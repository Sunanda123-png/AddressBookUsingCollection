package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.ContactsCreation;

import java.util.Scanner;

public class AddressBook {
    public static void main (String[] args){
        System.out.println("Welcome to the Addressbook");
        Scanner scanner=new Scanner(System.in);
        ContactsCreation contactsCreation=new ContactsCreation();
        contactsCreation.addContacts(scanner);
        contactsCreation.display();
        contactsCreation.editContact(scanner);
        contactsCreation.display();
        contactsCreation.delete(scanner);
        contactsCreation.display();
    }
}
