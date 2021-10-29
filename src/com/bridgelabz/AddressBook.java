package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.ContactsCreation;

import java.util.Scanner;

import static java.lang.System.exit;


public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book problem statement");

        ContactsCreation contactCreation = new ContactsCreation();
        contactCreation.optionToCreateBook();
    }
}
