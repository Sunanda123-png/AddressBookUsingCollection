package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.Contacts;

import java.util.Scanner;

public class ContactsCreation {
    Contacts contact=new Contacts();
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
            long phonenumber = scanner.nextLong();
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
}
