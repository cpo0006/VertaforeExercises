/*
 * Vertafore Exercises
 * Filename: VertaforeExercises.java
 * Author: Collin O'Connor
 * Last edit: 1/23/2019
 */

import java.util.Arrays;
import java.util.Random;

public class VertaforeExercises
{

   public static void main(String[] args) {
      //testing data
      int[] arrTest = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      String textTest = "abbreviation";
      String[] textArrTest = {"arbitrary", "internalization", "localization", "automatically", "arbitrary", "accessibility"};
      VertaforeExercises vecpo = new VertaforeExercises();
      
      //Exercise 1
      int[] arrRet = vecpo.scramble(arrTest); 
      System.out.println("Scrambled Array: " + Arrays.toString(arrRet));
      
      //Exercise 2
      System.out.println(vecpo.abbreviate(textTest));
      
      //Exercise 3
      boolean[] uniqueAbbr = vecpo.abbrCompare(textArrTest);
      System.out.println("Is abbreviation unique: " + Arrays.toString(uniqueAbbr));
      return;
   }


	/* 
	 * A small function that unsorts an already sorted array.
	 * Assumes data type of int and array is either ascending or descending.
	 */
   public int[] scramble(int[] arrIn) {
      Random rnd = new Random();
      for (int i = 0; i < arrIn.length; i++)
      {
         //get a random unused index
         int newIndex = rnd.nextInt(arrIn.length);
         //swap
         int temp = arrIn[i];
         arrIn[i] = arrIn[newIndex];
         arrIn[newIndex] = temp;
      }
   
      return arrIn;
   
   }
   
   
   /*
    * A small function that takes a string and converts it to an abbreviation
    * that consists of the first letter, a number representing the characters between
    * the first letter and the last letter, and finally the last letter.
    * Assumes the string contains no numbers.
    */
    
   public String abbreviate(String text) {
      if (text.length() < 2) {
         return "String requires at least two characters";
      }
      int abbrNum = text.length() - 2;
      String abbrFirst = text.substring(0,1);
      String abbrLast = text.substring(text.length() - 1, text.length());
      return abbrFirst + abbrNum + abbrLast;
   }
   
   /*
    * A function that compares the abbreviations (by the standards above)
    * of the words in the array, to see if the word abbreviation is unique.
    */
   public boolean[] abbrCompare(String[] dictionary) {
      boolean[] isUnique = new boolean[dictionary.length];
      String[] newDictionary = new String[dictionary.length];
      //gets abbreviations
      for (int i = 0; i < dictionary.length; i++){
         newDictionary[i] = abbreviate(dictionary[i]);
         isUnique[i] = true;
      }
      //checks each abbreviation against every other abbreviation
      //to see if it is unique.
      for (int i = 0; i < newDictionary.length; i++){
         for (int j = 0; j < newDictionary.length; j++){
            if (i == j) {
               continue;
            }
            if (newDictionary[i].equals(newDictionary[j])) {
               isUnique[i] = false;
               isUnique[j] = false;
            }
            else {
               if (isUnique[i] == false) {
                  break;
               }
               isUnique[i] = true;
            }
         }
      }
      return isUnique;
   }
   
}