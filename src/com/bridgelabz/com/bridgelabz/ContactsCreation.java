package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author:- Sunanda Shil
 * Date:-26/10/2021
 */

public class ContactsCreation {

    //Adding the contact details
    public LinkedList<Contacts> addContacts(Scanner scanner, LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();
            System.out.println("Last Name :");
            String lastName = scanner.next();
            System.out.println("Address :");
            String address = scanner.next();
            System.out.println("City :");
            String city = scanner.next();
            System.out.println("State :");
            String state = scanner.next();
            System.out.println("Zip Code :");
            int zip = scanner.nextInt();
            System.out.println("Phone Number :");
            String phonenumber = scanner.next();
            System.out.println("Email :");
            String email = scanner.next();
            Contacts contact=new Contacts();
            contact.setFirstname(firstName);
            contact.setLastname(lastName);
            contact.setAddress(address);
            contact.setCity(city);
            contact.setState(state);
            contact.setZip(zip);
            contact.setPhonenumber(phonenumber);
            contact.setEmail(email);
            contactList.add(contact);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return contactList;
    }
    public int searchname(Scanner scanner, LinkedList<Contacts> contactList) {
        try {
            String searchName = scanner.next();
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstname().equals(searchName))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    //Edit Existing contact details
    public void editContacts(Scanner scanner, LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            int name = searchname(scanner, contactList);

            if (name == -1)
                System.out.println("Name not found");
            else {
                Contacts contact = contactList.get(name);
                System.out.println(contact);

                System.out.println("What do you want to edit \n" +
                        "1. First Name / 2. Last Name / 3. Address / 4. City / 5. State " + "/ 6. Zip code / 7. Phone Number / 8. Email");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String newFirstName = scanner.next();
                        contact.setFirstname(newFirstName);
                        break;

                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = scanner.next();
                        contact.setLastname(newLastName);
                        break;

                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = scanner.next();
                        contact.setAddress(newAddress);
                        break;

                    case 4:
                        System.out.println("Enter new City");
                        String newCity = scanner.next();
                        contact.setCity(newCity);
                        break;

                    case 5:
                        System.out.println("Enter new State");
                        String newState = scanner.next();
                        contact.setState(newState);
                        break;

                    case 6:
                        System.out.println("Enter new Zip code");
                        int newZip = scanner.nextInt();
                        contact.setZip(newZip);
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number");
                        String newPhonenumber = scanner.next();
                        contact.setPhonenumber(newPhonenumber);
                        break;

                    case 8:
                        System.out.println("Enter new Email");
                        String newEmail = scanner.next();
                        contact.setEmail(newEmail);
                        break;
                }
            }
            System.out.println("SUCCESSFUL");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteContact(Scanner scanner, LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            int delete = searchname(scanner, contactList);

            if (delete == -1)
                System.out.println("Name not found");
            else {
                contactList.remove(delete);
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Display all the details of contact
    public void displayContact(LinkedList<Contacts> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);
    }
}
