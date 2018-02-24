package DataManagement;
import java.io.*;
import java.util.*;

public class Test_Main {

    public static void main(String[] args){
        DataManager dm = new DataManager("src\\DataManagement\\txtdata.txt");
        Person[] people = dm.parsePeople(dm.readFile());
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i]);
        }
    }

}
