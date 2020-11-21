package productcurdapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcurdapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//creating 
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.save(product);
	}
	
	

	//reading all product
    public List<Product> getProduct(){ 
    	List<Product> product = this.hibernateTemplate.loadAll(Product.class);
    	return product;
    }
    
    //reading a single product
    public Product getProduct(int pid) {
    	Product product = this.hibernateTemplate.get(Product.class, pid);
    	return product;
    }
    
    //delete product
    @Transactional
    public void delete(int pid) {
    	Product product = this.hibernateTemplate.get(Product.class, pid);
    	this.hibernateTemplate.delete(product);
    }

    //update product
	@Transactional
	public void update(Product product) {
		this.hibernateTemplate.update(product);
	}
	
	
}

