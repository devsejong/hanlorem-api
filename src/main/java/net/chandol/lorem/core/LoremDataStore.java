package net.chandol.lorem.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class LoremDataStore {

    private String[] paragraph;
    private String[] firstName;
    private String[] lastName;

    private static LoremDataStore dataStore;

    private LoremDataStore() {
        init();
    }

    static LoremDataStore getInstance() {
        if (dataStore == null)
            dataStore = new LoremDataStore();

        return dataStore;
    }

    private void init() {
        String rawParagraph = convertStringArray("paragraph.txt");
        paragraph = rawParagraph.split("\\r?\\n");

        String rawlastName = convertStringArray("lastName.txt");
        rawlastName = rawlastName.replace("\n", " ");
        lastName = rawlastName.split(" ");

        String rawFirstName = convertStringArray("firstName.txt");
        firstName = rawFirstName.split(" ");
    }

    private static String convertStringArray(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("FileNotFound", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    public String[] getSentence() {
        return paragraph;
    }

    public String[] getFirstName() {
        return firstName;
    }

    public String[] getLastName() {
        return lastName;
    }

}
