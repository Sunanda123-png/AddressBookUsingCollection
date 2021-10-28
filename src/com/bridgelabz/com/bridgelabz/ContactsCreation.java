package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author:- Sunanda Shil
 * Date:-26/10/2021
 */

public class ContactsCreation {
    Scanner scanner = new Scanner(System.in);

    public void optionToCreateBook() {
        try {
            HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();

            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "0. EXIT");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBook = scanner.next();
                        LinkedList<Contacts> contactList = new LinkedList<>();
                        optionToCreateContact(contactList, contactBook, newBook);
                        break;

                    case 2:
                        System.out.println(contactBook.keySet());
                        System.out.println("Which address book do you want to access?");
                        String existingBook = scanner.next();

                        if (contactBook.containsKey(existingBook)) {
                            contactList = contactBook.get(existingBook);
                            optionToCreateContact(contactList, contactBook, existingBook);
                        } else
                            System.out.println("Book not found");
                        break;

                    case 3:
                        int serialNo = 1;
                        for (String book : contactBook.keySet()) {
                            System.out.println(serialNo + ". " + book);
                            serialNo++;
                        }

                        System.out.println("\n" + contactBook);
                        break;

                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void optionToCreateContact(LinkedList<Contacts> contactList,
                                       HashMap<String, LinkedList<Contacts>> contactBook, String addressBook) {
        try {
            boolean run = true;
            while (run) {
                System.out.println("\nWhat would u like to do with contacts? \n" +
                        "1. ADD     \n" +
                        "2. DISPLAY \n" +
                        "3. EDIT    \n" +
                        "4. REMOVE  \n" +
                        "0. EXIT    \n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        LinkedList<Contacts> multiContactInBook = addContacts(contactList);
                        contactBook.put(addressBook, multiContactInBook);
                        break;
                    case 2:
                        displayContact(contactList);
                        break;
                    case 3:
                        editContacts(contactList);
                        break;
                    case 4:
                        deleteContact(contactList);
                        break;
                    default:
                        run = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }


    //Adding the contact details
    public LinkedList<Contacts> addContacts(LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();
            int  existingName = searchname(firstName, contactList);
            if(existingName==-1){
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
            else {
                System.out.println("Allreay exist this name");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return contactList;
    }
    private int searchname(String searchName, LinkedList<Contacts> contactList) {
        try {
            String searchname = scanner.next();
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstname().equals(searchname))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    //Edit Existing contact details
    public void editContacts(LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            String searchName = scanner.next();
            int name = searchname(searchName, contactList);

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
    public void deleteContact(LinkedList<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            String searchname = scanner.next();
            int delete = searchname(searchname, contactList);

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
