/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.engine;
import java.util.*;
import java.io.*;
/**
 *
 * @author jerald
 */
public class SearchEngine {

	public static void main(String[] args)
	{
		Hashtable<String, String> ht = new Hashtable<String, String>();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the filename that you want to Search keyword for.");
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(kb.nextLine()));//reads information from the file specified by user input
			System.out.println("The file was read. Processing information, please wait...");
			while(br.ready())//should repeat until there are no more lines to read
			{
				String line = br.readLine();//assigns the line read by the readerr to line
				String[] result = line.split("\\s");//tokenizes the line into seperate strings, based on spaces only
                            for (String result1 : result) {
                                if (!ht.containsKey(result1)) {
                                    ht.put(result1, line); //assigns a key to the line
                                } else {
                                    ht.put(result1, line+"\n" + ht.get(result1)); //if a key was assigned to a value already we will
                                    //assign the old value to the new value to assosciate with this
                                    //key and emulate an index
                                }
                            }
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		System.out.println(ht);
		do
		{
			System.out.println("Enter a keyword to search for.\n");
			System.out.println(ht.get(kb.nextLine()));
			System.out.println("\nKeep searching? Enter any key to continue, or type <NO> to end the process");
		}while(!kb.nextLine().equalsIgnoreCase("<NO>"));
		try
		{
			br.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}//end main
}