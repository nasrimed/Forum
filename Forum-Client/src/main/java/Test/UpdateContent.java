package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Content;
import Services.ContentServicesRemote;


public class UpdateContent {
	
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ContentServicesRemote contentServicesRemote = (ContentServicesRemote) context.lookup(
				"Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote");

		Content contentFound = contentServicesRemote.findContentById(2);
		contentFound.setTitle("the ring");
		
		contentFound.setTrailer("www.youtube.com");
		

		contentServicesRemote.updateContent(contentFound);

	}

}
