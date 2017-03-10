package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Services.ContentServicesRemote;



public class DeleteByIdTest {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ContentServicesRemote contentServicesRemote = (ContentServicesRemote) context.lookup(
				"Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote");

		contentServicesRemote.deleteContentById(1);
	}

}
