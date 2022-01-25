package Q1BL4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class NameFileSorter
{
    public static void main(String[] args) throws FileNotFoundException
    {
        header("James Morales", 251136192);
        Map<String, Integer> trees = new TreeMap<>();
        Map<String, Integer> trees1 = new TreeMap<>();


        //1. Here we create a File reference variable with the file name that we want to read from as an argument (with .txt)
        File rf = new File("SE2205Students.txt");

        //2. We create a Scanner type reference variable that will scan the file (by referring to the File reference variable as an argument)
        Scanner fileInfo = new Scanner(rf);

        //3. Here we are checking if the file even exists
        if (!rf.exists()) {
            //4. If the file does not exist, we leave with exit code 0.
            System.exit(0);
        }

        //5. This is just cosmetic
        else {
            System.out.println("List of the Number of students with the same Last Names:");
            System.out.println("Last Name\tnumbers");
            System.out.println("_______________________");
        }
        while (fileInfo.hasNextLine())
        {
            String words = fileInfo.nextLine();
            String lastName = words.split(" ")[0];
            if (trees1.get(lastName) == null)
            {
                trees1.put(lastName,1);
            }
            else
            {
                int value = trees1.get(lastName);
                value++;
                trees1.put(lastName, value);
            }
        }

        Set<Map.Entry<String, Integer>> set1 = trees1.entrySet(); // Creating a set from map’s keyset to print the key and values
        for (Map.Entry<String, Integer> entry1 : set1)
        {
            if(entry1.getValue()>1)
            {
                if (entry1.getKey().length()<3)
                {
                    System.out.println(entry1.getKey() + "\t\t\t" + entry1.getValue());
                }
                else
                    {
                        System.out.println(entry1.getKey() + "\t\t" + entry1.getValue());
                    }
            }
        }
        fileInfo.close();


        //1. Here we create a File reference variable with the file name that we want to read from as an argument (with .txt)
        File rf2 = new File("SE2205Students.txt");

        //2. We create a Scanner type reference variable that will scan the file (by referring to the File reference variable as an argument)
        Scanner fileInfo2 = new Scanner(rf2);

        //3. Here we are checking if the file even exists
        if (!rf2.exists()) {
            //4. If the file does not exist, we leave with exit code 0.
            System.exit(0);
        }
        else
            {
            System.out.println("\nList of the Number of students with the same First Names:");
            System.out.println("First Name\tnumbers");
            System.out.println("_______________________");
        }
        //This is for first names .length-1 LAST NAMES is 0 as index
        while (fileInfo2.hasNextLine())
        {
            String words = fileInfo2.nextLine();
            String firstName = words.split(" ")[words.split(" ").length-1];
            if (trees.get(firstName) == null)
            {
                trees.put(firstName,1);
            }
            else
            {
                int value = trees.get(firstName);
                value++;
                trees.put(firstName, value);
            }
        }

        Set<Map.Entry<String, Integer>> set = trees.entrySet(); // Creating a set from map’s keyset to print the key and values
        for (Map.Entry<String, Integer> entry : set)
        {
            if(entry.getValue()>1)
            {
                System.out.println(entry.getKey() + "\t\t" + entry.getValue());
            }
        }
            fileInfo.close();
        footer();

        }

    public static void header(String name, int studentNum)
    {
        String nm = name;
        int sN = studentNum;

        System.out.println("_______________________________________");
        System.out.println("|  "+ nm + " ********* " + sN+"  |");
        System.out.println("---------------------------------------\n");

    }

    public static void footer()
    {
        System.out.println("\nGoodbye from James :)");
    }
}
