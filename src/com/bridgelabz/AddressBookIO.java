package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class AddressBookIO {
    private static final String FILE_NAME = "Contact-Details.txt";
    public void writeContactInfo(Map<String, List<Contacts>> addressBooks) {
        Path path = Paths.get(FILE_NAME);
        StringBuilder contactsBuilder = new StringBuilder();
        addressBooks.keySet()
                .forEach(keyOfBook -> {
                    contactsBuilder.append("\n")
                            .append(keyOfBook)
                            .append(" --->\n");
                    addressBooks.get(keyOfBook)
                            .forEach(contact -> {
                                String line = contact.toString();
                                contactsBuilder.append(line);
                            });
                });
        try {
            Files.deleteIfExists(path);
            Files.write(path, contactsBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
