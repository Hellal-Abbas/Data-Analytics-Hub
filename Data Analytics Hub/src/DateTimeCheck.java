import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeCheck {
	
    public static boolean CheckValidity(String DateTime) {

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
    
  

}
