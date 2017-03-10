package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Services.ContentServicesRemote;


public class AddTest {
	
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ContentServicesRemote contentServicesRemote = (ContentServicesRemote) context.lookup(
				"Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote");

		
		String title= "Titanic"; 
		String genre="Romance";
		String trailer="www.youtube.com";
		String description="Romance Movie On a Sinking boat";
		Date date = null;
		try {
			date= new SimpleDateFormat("yyyy-MM-dd").parse("1998-07-04");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		contentServicesRemote.addContent(title,genre,description,trailer,date);
	}

}

