import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        
    String[] arrOfStr = s.split("");
         
    String curlyOpeningBrace = "{";
    String squareOpeningBrace = "[";
    String openingBrace = "(";
    String closingBrace = ")";
    String curlyClosingBrace = "}";
    String squareClosingBrace = "]";
    
    Stack<String> stack = new Stack<>();
    
      for (String a : arrOfStr) {
          if(a.equals(curlyOpeningBrace) || a.equals(squareOpeningBrace) || a.equals(openingBrace))
          {
              stack.push(a);
          }
          if(a.equals(curlyClosingBrace))
          {
              String popped = stack.pop();
         
              if(popped.equals(curlyOpeningBrace)){
                  if(stack.empty()){
                       return "YES"; 
                  }
              }else {
                  return "NO";
              }
          }
          
            if(a.equals(squareClosingBrace))
          {
              String popped = stack.pop();
         
              if(popped.equals(squareOpeningBrace)){
                  if(stack.empty()){
                       return "YES"; 
                  }
              }else {
                  return "NO";
              }
          }
          
            if(a.equals(closingBrace))
          {
              String popped = stack.pop();
         
              if(popped.equals(openingBrace)){
                  if(stack.empty()){
                       return "YES"; 
                  }
              }else {
                  return "NO";
              }
          }
        }

    
    return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
