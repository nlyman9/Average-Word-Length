import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
* This class calculates the average length of an english word using a dictionary
* from http://www.gwicks.net/dictionaries.htm. It increments the total characters after each line
* and divides by the total number of words to get the average.
*/
public class AvgLength {
  private static DecimalFormat df = new DecimalFormat("#.####");      //convert the double to fewer decimal places
  public static void main(String [] args) {
    File dictionary = new File("engmix.txt");                         //set scanner to dictionary file
    Scanner sc = null;
    try {
          sc = new Scanner(dictionary);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    double numWords = 0;
    double totalChars = 0;
    String word = "";
    while (true) {                             //add characters until the EOF
      if (sc.hasNextLine()) {
        word = sc.nextLine();
      }
      else {                                  //EOF is reached so
        finished(numWords, totalChars);       //calculate the average and exit
      }
      numWords++;
      totalChars = totalChars + word.length();
    }
  }
  /**
  * This method calculates the average word length by dividing total characters by total number of words
  * @param numWords The total number of words in the dictionary
  * @param totalChars The total number of characters in the dictionary
  */
  static void finished(double numWords, double totalChars) {
    totalChars = totalChars / numWords;
    System.out.println("Average word length in English is: " + df.format(totalChars));
    System.exit(1);
  }
}
