package Test;

import java.text.SimpleDateFormat;
import java.util.Date;


import Entities.Category;

import businessDelegate.ContentServicesDelegate;



public class AddTest {
	
	public static void main(String[] args)  {
		
		
		String title= "The Ring"; 
		String genre="Romance";
		String trailer="www.youtube.com";
		String description="Romance Movie On a Sinking boat";
		
		Date date = null;
		Category category = ContentServicesDelegate.findCategoryById(4);
		try {
			date= new SimpleDateFormat("yyyy-MM-dd").parse("1998-07-04");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		ContentServicesDelegate.addContent(title,genre,description,trailer,date,category);
	}

}

