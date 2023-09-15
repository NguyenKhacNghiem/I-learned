package lab9lab10.service;

import java.util.List;

import lab9lab10.model.Product;

public interface ProductService {
	List<Product> getAll();
	Product getOne(int id);
	void save(Product product);
	void delete(int id);
}
