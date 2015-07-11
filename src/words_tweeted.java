import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class words_tweeted {
public static void main(String[] args) throws IOException
{
	HashMap<String, Integer> wordCount=new HashMap<String,Integer>();
	BufferedReader br = new BufferedReader(new FileReader(args[0]));
	try {
        StringBuilder sb = new StringBuilder();
        String nextTweet = br.readLine();
        //Build 
        while (nextTweet != null) {
           //Pass Line to getWordCountFromLine function
        	getWordCountFromLine(nextTweet, wordCount);
            nextTweet = br.readLine();
        }
        //Get Results in a Sorted Manner
        List sortedWords = new ArrayList(wordCount.keySet());
        Collections.sort(sortedWords);
        Iterator<String> it = sortedWords.iterator();
       try {
		// BufferedWriter bw = new BufferedWriter(new FileWriter(""));
		File file = new File(args[1]);
		//Create file if doesn't exist
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		while (it.hasNext()) {
			String nextWord = (String) it.next();
			String finalWC = nextWord + " = " + wordCount.get(nextWord);
			writer.write(finalWC+"\n");
			//System.out.println(finalWC);
			it.remove(); // avoids a ConcurrentModificationException
		}
		writer.flush();
		writer.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
    } finally {
        br.close();
    }
    
}
public static void getWordCountFromLine(String nextLine, HashMap<String, Integer> wordCount)
{
	String[] tokens=nextLine.split(" ");
	for(String nextWord:tokens)
	if(wordCount.containsKey(nextWord))
		wordCount.put(nextWord, wordCount.get(nextWord)+1);
	else
		wordCount.put(nextWord, 1);
}

}
