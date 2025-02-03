/**
 * This program uses recursion to do different tasks
 * CS 160-1
 * Kraft
 * @author Aayush Talati
 */

public class RecursiveMethods {
    public static void main(String[] args) {
        RecursiveMethods p6 = new RecursiveMethods();
        //Some testing on the methods
    }
    public int byLeapsAndBounds(int n) {
        //Part I code goes here
        //This is the base case to prevent Stack Overflow
        if ((n == 0) || (n == 1)) {
            return 1;
        }
        //Recursive case
        //Each move forward can be either 1 space (a leap)
        //or 2 spaces (a bound)
        return byLeapsAndBounds(n-1) + byLeapsAndBounds(n-2);
    }
    public int subCount(String str, String subStr) {
        //Part II code goes here
        //Base case in the event that str is empty or the
        //subStr is longer than str
        if (str.isEmpty() || str.length() < subStr.length()) {
            return 0;
        }
        //The recursive and base case
        //The base case is when we get to the end of the str
        //We use recursion to count how many times the subStr shows
        //in the str
        if (str.substring(0, subStr.length()).equals(subStr)) {
            return 1 + subCount(str.substring(subStr.length()), subStr);
        } else {
            return subCount(str.substring(1), subStr);
        }
    }
    public int binarySearch(int[] array, int target, int left, int right) {
        //Part III code goes here
        //Base case in the case that the left side
        //is larger than the right
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        //If target is found at the middle of the array
        //we return the middle value
        if (array[middle] == target) {
            return middle;
        }
        //If the target is less than the value at the middle index,
        //search in the left half
        else if (target < array[middle]) {
            return binarySearch(array, target, left, middle - 1);
        }
        //If the target is greater than the value at the middle index
        //search in the right half
        else {
            return binarySearch(array, target, middle + 1, right);
        }
    }
}
