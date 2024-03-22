
package in.uday.repo;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import in.uday.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	
	public List<Product> findAll(Specification<Product> spec);
}
