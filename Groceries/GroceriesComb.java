package Groceries;

import java.util.*;

	public class GroceriesComb{
	    private static int combinationsFound = 0;
	    
	    private static void findCombinations(int[] items, int remainingAmount, String current, int start) {
	        if (combinationsFound == 5) {
	            return;
	        }
	        
	        if (remainingAmount == 0) {
	            System.out.print("["+current.trim()+"]");
	            combinationsFound++;
	            return;
	        }

	        for (int i = start; i < items.length; i++) {
	            if (items[i] <= remainingAmount) {
	                findCombinations(items, remainingAmount - items[i], current + " " + items[i],i);
	            }
	           
	        }
	    }

	    public static void main(String[] args) {
	        int[] items = {20,10, 60, 40, 30, 200, 250};
	        int n=items.length;

	       int temp = 0;
	        for (int i = 0; i < items.length; i++) {
	            for (int j = i + 1; j < items.length; j++) {
	                if (items[i] < items[j]) {
	                    temp = items[i];
	                    items[i] = items[j];
	                    items[j] = temp;
	                }
	            }
	        }
	       
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter Amount: ");
	        int amount = scan.nextInt();
	        scan.close();

	        findCombinations(items, amount, "", 0);
	    
	    
	    }
	}



