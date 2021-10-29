package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;

import java.util.*;

/**
 * Author:- Sunanda Shil
 * Date:-26/10/2021
 */

public class ContactsCreation {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();
    public void optionToCreateBook() {
        try {
            HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();

            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "4. search location \n" +
                        "5. Contact number \n" +
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
                    case 4:
                        System.out.println("Enter Name for City/State");
                        String nameForLocation = scanner.next();
                        System.out.println(searchInLocation(nameForLocation));
                        break;
                    case 5:
                        System.out.println("Enter First Name");
                        String nameForContact = scanner.next();
                        getContactNo(nameForContact);
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
    private void getContactNo(String nameForContact) {
        try {
            for (String keyOfBook : contactBook.keySet()) {
                for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {
                    if (contactBook.get(keyOfBook).get(index).getFirstname().equals(nameForContact)) {

                        String lastName = contactBook.get(keyOfBook).get(index).getLastname();
                        String phoneNo = contactBook.get(keyOfBook).get(index).getPhonenumber();

                        System.out.println(keyOfBook + " : " + nameForContact + " " + lastName + " --> " + phoneNo);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Hashtable<String, List<String>> searchInLocation(String nameForLocation) {
        try {
            Hashtable<String, List<String>> searchResult = new Hashtable<>();
            List<String> contactList;
            for (String keyOfBook : contactBook.keySet()) {

                contactList = new ArrayList<>();
                for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {

                    if (contactBook.get(keyOfBook).get(index).getCity().equals(nameForLocation))
                        contactList.add(contactBook.get(keyOfBook).get(index).getFirstname());

                    if (contactBook.get(keyOfBook).get(index).getState().equals(nameForLocation))
                        contactList.add(contactBook.get(keyOfBook).get(index).getFirstname());
                }
                if (!contactList.isEmpty())
                    searchResult.put(keyOfBook, contactList);
            }
            System.out.println(searchResult);
            return searchResult;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
    public void editContacts(LinkedList<Contacts> contactList) {
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
    public void deleteContact(LinkedList<Contacts> contactList) {
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
