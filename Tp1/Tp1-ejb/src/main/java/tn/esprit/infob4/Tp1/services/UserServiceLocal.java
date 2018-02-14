package tn.esprit.infob4.Tp1.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infob4.Tp1.persistence.Customer;
import tn.esprit.infob4.Tp1.persistence.User;
@Local
public interface UserServiceLocal {
	void createUser(User user);
	void saveCustomer(Customer customer);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	User findUserByLogin(String login);
}
