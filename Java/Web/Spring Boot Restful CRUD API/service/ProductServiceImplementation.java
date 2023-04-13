package lab9lab10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab9lab10.model.Product;
import lab9lab10.model.ProductOrder;
import lab9lab10.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	private ProductRepository pr;
	
	@Override
	public List<Product> getAll() {
		return pr.findAll();
	}

	@Override
	public Product getOne(int id) {
		Optional<Product> product = pr.findById(id);

		if (product.isPresent())
			return product.get();

		return null;
	}

	@Override
	public void save(Product product) {
		pr.save(product);
	}

	@Override
	public void delete(int id) {
		if(getOne(id) != null) 
			pr.deleteById(id);
	}

}
