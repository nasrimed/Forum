package tn.esprit.infob4.Tp1.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infob4.Tp1.persistence.Customer;
import tn.esprit.infob4.Tp1.persistence.User;


@Remote
public interface UserServiceRemote {
	void createUser(User user);
	void saveCustomer(Customer customer);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	User findUserByLogin(String login);
}
