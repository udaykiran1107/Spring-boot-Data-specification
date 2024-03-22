
package in.uday.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import in.uday.entity.Product;
import in.uday.repo.ProductRepo;
import in.uday.spec.ProductSpecifications;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public void getProductsSpec(String name, Double minPrice, Double maxPrice) {

		Specification<Product> spec = Specification.where(null);

		if (name != null) {
			spec = spec.and(ProductSpecifications.nameLike(name));
		}

		if (minPrice != null) {
			spec = spec.and(ProductSpecifications.priceGreaterThan(minPrice));
		}

		if (maxPrice != null) {
			spec = spec.and(ProductSpecifications.priceLessThan(maxPrice));
		}

		List<Product> all = repo.findAll(spec);
		all.forEach(System.out::println);

	}


	public void getProducts() {

		Product p = new Product();
		p.setCategory("Mobiles");
		p.setPrice(10000.00);

		Example<Product> of = Example.of(p);

		List<Product> findAll = repo.findAll(of);
		findAll.forEach(System.out::println);
	}

	public void saveProducts() {
		Product p1 = new Product();
		p1.setCategory("computers");
		p1.setName("asus");
		p1.setPrice(10000.00);

		Product p2 = new Product();
		p2.setCategory("computers");
		p2.setName("dell");
		p2.setPrice(50000.00);

		Product p3 = new Product();
		p3.setCategory("computers");
		p3.setName("hp");
		p3.setPrice(30000.00);

		Product p4 = new Product();
		p4.setCategory("computers");
		p4.setName("mac");
		p4.setPrice(40000.00);

		repo.saveAll(Arrays.asList(p1, p2, p3, p4));

	}

}
