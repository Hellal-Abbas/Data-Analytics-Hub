import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PostsValueCheck {
	
    public static boolean DateTimeCheck(String DateTime) {

    	// Initialising the type of date time format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dateFormat.setLenient(false);

        try {
        	// If user inputed data and time is in the correct, returns true 
            dateFormat.parse(DateTime.trim());
            
        } catch (ParseException pe) {
            // If user inputed date and time is in the wrong format, returns false
        	return false;
        }
        return true;
    }
    
    public static int IntegerCheck(Integer value) {
    	
    	
		return value;
    	
    }
    
//    Post ID:
//
//    try {
//
//    	// Allows user to input Post ID
//        System.out.print("\nPlease provide the post ID: ");
//        PostID = scannerPostID.nextInt();
//        scannerPostID.nextLine();
//
//        // Prevents Post ID from being less than 1 and prints out a message
//        if (PostID < 1) {
//            System.out.println("PostID must be a number greater than 0!");
//            repeatPostID = true;
//
//        // Prevents user adding a duplicate Post ID and prints message
//        } else if (postHashMap.containsKey(PostID) == true) {
//            System.out.println("This PostID is already in use!");
//            repeatPostID = true;
//
//        } else {
//        	// If all is successful, prevents while loop from restarting
//            repeatPostID = false;
//
//        }
//
//    } catch (InputMismatchException e) {
//    	// Prevents user from inputting anything other than a number and prints message
//        System.out.println("Error: Post ID must be a number (e.g. \\\"123456\\\").");
//
//    }
    
  
    
//    likes
    
//    try {
//
//        // Allows user to input the amount of likes for the post
//        System.out.print("\nPlease provide the number of likes of the post: ");
//        Likes = scannerLikes.nextInt();
//        scannerLikes.nextLine();
//        repeatLikes = false;
//
//        if (Likes < 0) {
//        	// Prevents user from inputting likes to be less than 0 and prints message
//            System.out.println("Shares must be a number greater than 0!");
//            repeatLikes = true;
//
//        } else {
//        	// If all is successful, prevents while loop from restarting
//            repeatLikes = false;
//
//        }
//
//    } catch (InputMismatchException e) {
//    	// Prevents user from inputting anything other than a number and prints message
//        repeatLikes = true;
//        System.out.println("Error: Post ID must be a number (e.g. \\\"123456\\\").");
//
//    }
    
//    shares
    
//    try {
//        // Allows user to input the amount of shares for the post
//        System.out.print("\nPlease provide the number of shares of the post: ");
//        Shares = scannerShares.nextInt();
//        scannerShares.nextLine();
//        repeatShares = false;
//
//        if (Shares < 0) {
//        	// Prevents user from inputting shares to be less than 0 and prints message
//            System.out.println("Shares must be a number greater than 0!");
//            repeatShares = true;
//
//        } else {
//        	// If all is successful, prevents while loop from restarting
//            repeatShares = false;
//
//        }
//
//    } catch (InputMismatchException e) {
//    	// Prevents user from inputting anything other than a number and prints message
//        repeatShares = true;
//        System.out.println("Error: Post ID must be a number (e.g. \\\"123456\\\").");
//
//    }
    
//    dateTime

//    // Allows user to input the date and time
//    System.out.print("\nPlease provide the date and time of the post in the format of DD/MM/YYYY HH:MM: ");
//    DateTime = scanner.nextLine();
//    
//    // Adds date time format when correct
//    if (Menu.DateTimeCheck(DateTime) == true) {
//        repeatDateTime = false;
//
//    // Prevents user from inputting wrong date time format
//    } else if (Menu.DateTimeCheck(DateTime) == false) {
//        System.out.println("The date and time must follow the format of DD/MM/YYYY HH:MM");
//        repeatDateTime = true;
//
//    }

    
    

}
