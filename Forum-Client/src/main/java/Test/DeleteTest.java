package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Content;
import Services.ContentServicesRemote;


public class DeleteTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ContentServicesRemote contentServicesRemote = (ContentServicesRemote) context.lookup(
				"Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote");

		Content content=contentServicesRemote.findContentById(1);
		

		contentServicesRemote.deleteContent(content);
	}
	
}
