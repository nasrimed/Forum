package Test;

import java.util.List;

import Entities.Category;
import Entities.Content;
import businessDelegate.ContentServicesDelegate;



public class FindContentByCategory {
	
	public static void main(String[] args)  {
		
Category category=new Category(4);
		Content contents = (Content) ContentServicesDelegate.findContentByCategory(category);

		
			System.out.println(contents.getTitle());
		

	}

}
