package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;
import java.util.Scanner;

/**
 * Author:- Sunanda Shil
 * Date:-26/10/2021
 */

public class ContactsCreation {
    //create object of Contacts
    Contacts contact=new Contacts();
    //Adding the contact details
    public void addContacts(Scanner scanner){
        try{
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.nextLine();
            System.out.println("Last Name :");
            String lastName = scanner.nextLine();
            System.out.println("Address :");
            String address = scanner.nextLine();
            System.out.println("City :");
            String city = scanner.nextLine();
            System.out.println("State :");
            String state = scanner.nextLine();
            System.out.println("Zip Code :");
            int zip = scanner.nextInt();
            System.out.println("Phone Number :");
            String phonenumber = scanner.next();
            System.out.println("Email :");
            String email = scanner.next();

            contact.setFirstname(firstName);
            contact.setLastname(lastName);
            contact.setAddress(address);
            contact.setCity(city);
            contact.setState(state);
            contact.setZip(zip);
            contact.setPhonenumber(phonenumber);
            contact.setEmail(email);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //Edit Existing contact details
    public void editContact(Scanner scanner) {

        System.out.println("What do you want to edit \n" +
                "1. First Name / 2. Last Name / 3. Address / 4. City / 5. State / 6. Zip code / 7. Phone Number / 8. Email");
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
    public void delete(Scanner scanner){
        System.out.println("Enter the name you want to delete:-");
        String name=scanner.next();
        if (name.equals(contact.getFirstname()))
        {
            contact.setFirstname(null);
            contact.setLastname(null);
            contact.setAddress(null);
            contact.setCity(null);
            contact.setState(null);
            contact.setPhonenumber(null);
            contact.setEmail(null);
        }

    }
    //Display all the details of contact
    public void display(){
        System.out.println(contact.getFirstname()+"\n"+contact.getLastname()+"\n"+contact.getAddress()+"\n"+contact.getCity()+"\n"+
                contact.getState()+"\n"+contact.getZip()+"\n"+contact.getPhonenumber()+"\n"+contact.getEmail());
    }

}
