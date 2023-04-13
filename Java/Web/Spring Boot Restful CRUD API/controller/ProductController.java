package lab9lab10.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab9lab10.model.Product;
import lab9lab10.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@GetMapping("/api/products")
	public List<Product> showAllProduct() {
		List<Product> products = ps.getAll();
		return products;
	}
	
	@PostMapping("/api/products")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
		if(product.getName().isBlank() || product.getPrice() < 0 || product.getBrand().isBlank() || product.getColor().isBlank())
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		Product newProduct = new Product(product.getName(), product.getPrice(), product.getBrand(), product.getColor());
		
		ps.save(newProduct);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/products/{id}")
	public ResponseEntity<Product> getProductInfo(@PathVariable int id) {
		Product product = ps.getOne(id);

		if (product != null)
			return new ResponseEntity<>(product, HttpStatus.OK);

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/api/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		Product updatedProduct = ps.getOne(id);

		if(updatedProduct != null) {
			updatedProduct.setName(product.getName());
			updatedProduct.setPrice(product.getPrice());
			updatedProduct.setBrand(product.getBrand());
			updatedProduct.setColor(product.getColor());
			
			ps.save(updatedProduct);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/api/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		Product product = ps.getOne(id);
		
		if(product == null)
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		ps.delete(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}
