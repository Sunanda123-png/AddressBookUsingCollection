package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;

import java.util.*;

/**
 * Author:- Sunanda Shil
 * Date:-26/10/2021
 */

public class ContactsCreation {
    static Scanner scanner = new Scanner(System.in);
    Map<String, List<Contacts>> contactBook = new HashMap<>();
    public void optionToCreateBook() {
        try {
            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "4. search location \n" +
                        "5. Contact number \n" +
                        "6. Sorting name"+
                        "0. EXIT");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBook = scanner.next();
                        List<Contacts> contactList = new LinkedList<>();
                        if (contactBook.containsKey(newBook))
                            System.out.println("Book already exists");
                        else
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
                        System.out.println("Enter Name for City");
                        String nameForCity = scanner.next();
                        searchAcrossCity(nameForCity);
                        break;
                    case 5:
                        System.out.println("Enter Name for State");
                        String nameForState = scanner.next();
                        searchAcrossState(nameForState);
                        break;
                    case 6:
                        sortContact();
                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void optionToCreateContact(List<Contacts> contactList, Map<String, List<Contacts>> addressBook, String newBook) {
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
                        List<Contacts> multiContactInBook = addContacts(contactList);
                        contactBook.put(newBook, multiContactInBook);
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
    public List<Contacts> addContacts(List<Contacts> contactList) {
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
    //searching the name in contact
    public int searchname(Scanner scanner, List<Contacts> contactList) {
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
    public void editContacts(List<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            int name = searchname(scanner, contactList);
            if (name ==-1)
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
    //To delete existing contact
    public void deleteContact(List<Contacts> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            int delete = searchname(scanner, contactList);

            if (delete== -1)
                System.out.println("Name not found");
            else {
                contactList.remove(delete);
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void searchAcrossCity(String contactsInCity) {
        try {
            for (String keyOfBook : contactBook.keySet()) {
                long noOfContactsInCity = contactBook.get(keyOfBook)
                        .stream()
                        .filter(contact -> contactsInCity.equals(contact.getCity()))
                        .count();
                System.out.println("Number of contact in city = " + noOfContactsInCity);
                contactBook.get(keyOfBook)
                        .stream()
                        .filter(contact -> contactsInCity.equals(contact.getCity()))
                        .forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void searchAcrossState(String contactsInState) {
        try {
            for (String keyOfBook : contactBook.keySet()) {
                long noOfContactsInState = contactBook.get(keyOfBook)
                        .stream()
                        .filter(contact -> contactsInState.equals(contact.getState()))
                        .count();
                System.out.println("Number of contact in city = " + noOfContactsInState);
                contactBook.get(keyOfBook)
                        .stream()
                        .filter(contact -> contactsInState.equals(contact.getState()))
                        .forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void sortContact(){
        boolean run = true;
        while (run) {
            System.out.println("How Would you like to sort\n" +
                    "1. By Firstname\n" +
                    "2. By State\n" +
                    "3. By Zip\n" +
                    "0. EXIT");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    contactBook.keySet().forEach(keyOfBook -> {
                        contactBook.get(keyOfBook)
                                .stream()
                                .sorted(Comparator.comparing(Contacts::getFirstname))
                                .forEach(System.out::println);
                    });
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
    //Display all the details of contact
    public void displayContact(List<Contacts> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);
    }
}
