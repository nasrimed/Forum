package tn.esprit.infob4.Tp1.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infob4.Tp1.persistence.Category;
import tn.esprit.infob4.Tp1.persistence.Product;

@Local
public interface CatalogServiceLocal {
	Product createProduct(Product product);
	void saveProduct(Product product);
	void removeProduct(Product product);
	List<Product> findAllProducts();
	
	List<Product> findProductsByCategory(Category category);
	
	
	Category createCategory(Category category);
	void saveCategory(Category category);
	void removeCategory(Category category);
	List<Category> findAllCategories();
	Category findCategoryByName(String name);
	
	byte[] findPictureByProductName(String productName);
}
