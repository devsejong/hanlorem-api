package net.chandol.lorem.core;

import java.util.Random;

public class Lorem {

    private static LoremDataStore dataStore = LoremDataStore.getInstance();
    private static Random random = new Random();

    public static String getSentence(){
        String[] paragraph = dataStore.getSentence();
        int i = random.nextInt(paragraph.length);

        return paragraph[i];
    }

    public static String getSentences(int count){
        StringBuilder sb= new StringBuilder();
        for(int idx = 0; idx < count; idx++){
            sb.append(getSentence());
            if (idx < count - 1) sb.append(" ");
        }

        return sb.toString();
    }

    public static String getSentences(int betweenStart, int betweenEnd){
        if(betweenEnd < betweenStart)
            throw new LoremException("betweenStart must bigger than betweenEnd.");

        int count = random.nextInt(betweenEnd - betweenStart) + betweenStart + 1;
        return getSentences(count);
    }


    public static String getParagraph(){
        return getSentences(2, 6);
    }

    public static String getParagraphs(int count){
        StringBuilder sb= new StringBuilder();
        for(int idx = 0; idx < count; idx++){
            sb.append(getParagraph());
            if (idx < count - 1) sb.append("\n\n");
        }

        return sb.toString();
    }


    public static String getParagraphs(int betweenStart, int betweenEnd){
        if(betweenEnd < betweenStart)
            throw new LoremException("betweenStart must bigger than betweenEnd.");

        int count = random.nextInt(betweenEnd - betweenStart) + betweenStart + 1;
        return getSentences(count);
    }

    public static String getFirstName(){
        String[] firstName = dataStore.getFirstName();
        int i = random.nextInt(firstName.length);

        return firstName[i];
    }

    public static String getLastName() {
        String[] lastName = dataStore.getLastName();
        int i = random.nextInt(lastName.length);

        return lastName[i];
    }

    public static String getName() {
        return getFirstName() + getLastName();
    }

    public static String getPhoneNumber() {
        return "010" + random.nextInt(10000) + random.nextInt(10000);
    }

}
