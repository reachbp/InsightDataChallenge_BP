# InsightDataChallenge_BP

This repository is my submission for the Insight Data  Science Data challenge. 

The code is organised as follows:
├── src  
│   ├── Unique_Median.java  
│   └── Words_Tweeted.java  
├── tweet_input  
│   └── tweets.txt  
└── tweet_output  
    ├── ft1.txt  
    └── ft2.txt  

This challenge is to implement two features:

Calculate the total number of times each word has been tweeted.
Calculate the median number of unique words per tweet, and update this median as tweets come in.

Navigate to the run.sh script which has shell commands to compile and run the two Java classes. 
The input/output parameters are hardcoded in the run.sh . 
To execute run.sh, go to command prompt and type ./run.sh
If it throws Permission Denied error, do a chmod 777 run.sh

Notes:
1) The total number of words tweeted is calculated using a HashMap data structure
2) The median of unique words per tweet is calculated by implementing StreamingMedians using min & max heaps
