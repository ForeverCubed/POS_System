package DataManagement;
import java.io.*;
import java.util.*;

public class DataManager {

    private String filename;
    private File file;
    private Scanner reader;
    private FileWriter writer;

    public DataManager(String filename){
        // storing the filename and file as private variables
        this.filename = filename;
        this.file = new File(filename);

        // try to create the reader and if it can't, print out an error message and make the local variable null.
        //TODO: have the filereader instead make a blank file to read from
        try {
            this.reader = new Scanner(this.file);
        } catch(Exception e) {
            System.out.println("Error reading file    " + e.getMessage());
            this.reader = null;
            return;
        }

    }

    // read from the stored file and return each line if the reader hasn't fucked up during init
    public String[] readFile(){
        if(reader == null){
            System.out.println("FileReader not found (shit's broke yo)");
            return new String[] {};
        }

        ArrayList<String> lines = new ArrayList<>();

        while(reader.hasNextLine()){
            String line = reader.nextLine();
            lines.add(line);
        }
        String[] filelines = new String[lines.size()];
        filelines = lines.toArray(filelines);
        return filelines;
    }

    // take in an array of string in the style of `"name",id,["positions"],pin`
    public Person[] parsePeople(String[] peopleIn){
        Person[] people = new Person[peopleIn.length];
        for(int i = 0; i < peopleIn.length; i++){
            String line = peopleIn[i];
            String[] values = line.split(",");
            Person p = new Person(values[0], Integer.valueOf(values[1]), values[2].split(";"), Integer.valueOf(values[3]));
            people[i] = p;
        }

        return people;
    }

    public void addPerson(Person p){
        try {
            this.writer = new FileWriter(this.file, true);
            this.writer.append("\n"+p.saveString());
            this.writer.close();
        } catch(Exception e){
            System.out.println("Dun goofed adding someone, "+e.getMessage());
        }
    }
}
