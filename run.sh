
#!/bin/bash
echo "Running word count and Median programs"
cd src
echo "Compiling ... words_tweeted.java....."
echo "......"
javac  -Xlint:deprecation words_tweeted.java 
echo "Running Words_tweeted.java....."
java words_tweeted ../tweet_input/tweets.txt ../tweet_output/ft1.txt
echo "Completed successfully. Check output at ./tweet_output/ft1.txt"

echo "Compiling... Unique_Median.java"
echo ".........."
javac  -Xlint:deprecation Unique_Median.java
echo "Running Unique Median program......"
java Unique_Median ../tweet_input/tweets.txt ../tweet_output/ft2.txt
echo " Out put is saved in  ./tweet_output/ft2.txt"

