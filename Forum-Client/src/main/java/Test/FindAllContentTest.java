package Test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Content;
import Services.ContentServicesRemote;



public class FindAllContentTest {
	
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ContentServicesRemote contentServicesRemote = (ContentServicesRemote) context.lookup(
				"Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote");

		List<Content> contents = contentServicesRemote.findAllContents();

		for (Content c : contents) {
			System.out.println(c.getTitle());
		}

	}

}
