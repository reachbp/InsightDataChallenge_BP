import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Unique_Median{
	
public static void main(String[] args) throws IOException
{
	Unique_Median streamingMedian=new Unique_Median();
	BufferedReader br = new BufferedReader(new FileReader(args[0]));
	File file = new File(args[1]);
	//Create file if doesn't exist
	file.createNewFile();
	FileWriter writer = new FileWriter(file);
	try {
        StringBuilder sb = new StringBuilder();
        String nextTweet = br.readLine();
        //Build 
        while (nextTweet != null) {
           //Pass Line to getWordCountFromLine function
        	int l1=getUniqueWordCount(nextTweet);
        	
            streamingMedian.addNumberToStream(l1);
            writer.write(streamingMedian.getMedian().toString()+"\n");
            nextTweet = br.readLine();
        }
       
    
		writer.flush();
		writer.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
    
}
public static int getUniqueWordCount(String nextLine)
{
	HashMap<String, Integer> wordCount=new HashMap<String,Integer>();
	
	String[] tokens=nextLine.split(" ");
	for(String nextWord:tokens)
	if(wordCount.containsKey(nextWord))
		wordCount.put(nextWord, wordCount.get(nextWord)+1);
	else
		wordCount.put(nextWord, 1);
	
	return wordCount.size();
}

//Implementaion of Streaming median

public Queue<Integer> minHeap;
public Queue<Integer> maxHeap;
public int numOfElements;
public Unique_Median() {
	minHeap = new PriorityQueue<Integer>();
	maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator()); 
	numOfElements = 0;
}
public void addNumberToStream(Integer num) {
	maxHeap.add(num);
	if (numOfElements%2 == 0) {
		if (minHeap.isEmpty()) {
			numOfElements++;
			return;
		}
		else if (maxHeap.peek() > minHeap.peek()) {
			Integer maxHeapRoot = maxHeap.poll();
			Integer minHeapRoot = minHeap.poll();
			maxHeap.add(minHeapRoot);
			minHeap.add(maxHeapRoot);
		} 
	} else {
		minHeap.add(maxHeap.poll());
	}
	numOfElements++;
}

public Double getMedian() {
	if (numOfElements%2 != 0)
		return new Double(maxHeap.peek());
	else
		return (maxHeap.peek() + minHeap.peek()) / 2.0; 
}

private class MaxHeapComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

}
