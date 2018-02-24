package DataManagement;
import java.io.*;
import java.util.*;

public class Test_Main {

    public static void main(String[] args){
        String filename = "src\\DataManagement\\txtdata.txt";
        DataManager dm = new DataManager(filename);
        dm.addPerson(new Person("person1",1, new String[]{"server", "owner"}, 4562, dm));
        Person[] people = dm.parsePeople(dm.readFile());
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i]);
        }
    }

}
