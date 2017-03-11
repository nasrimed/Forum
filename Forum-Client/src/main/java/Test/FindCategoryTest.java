package Test;




import businessDelegate.ContentServicesDelegate;
import Entities.Category;

public class FindCategoryTest {
	public static void main(String[] args)  {
		
		Category categoryFound= ContentServicesDelegate.findCategoryById(4);

		System.out.println(categoryFound.getDescription());
	}
}
	
	

