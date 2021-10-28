package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.ContactsCreation;

import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedList<Contacts> contactList = new LinkedList<>();
        ContactsCreation contactCreation = new ContactsCreation();
        while (true) {
            System.out.println("\nWhat you want to do\n"+"1. ADD\n"+"2. EDIT \n"+"3. DISPLAY\n"+"4. REMOVE \n"+"0. EXIT\n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    contactCreation.addContacts(scanner, contactList);
                    break;
                case 2:
                    contactCreation.editContacts(scanner,contactList);
                    break;
                case 3:
                    contactCreation.displayContact(contactList);
                    break;
                case 4:
                    contactCreation.deleteContact(scanner,contactList);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
