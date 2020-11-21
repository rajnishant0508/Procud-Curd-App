package productcurdapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcurdapp.dao.ProductDao;
import productcurdapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;

    @RequestMapping("/")
	public String home(Model model) {
    	List<Product> products = productDao.getProduct();
		model.addAttribute("product", products);
    	return "index";
	}
    
    @RequestMapping("/add-product")
    public String addProduct(Model model) {
    	model.addAttribute("title", "Add Product");
    	return "add_product_form";
    }
    
    @RequestMapping(path="/handle-product",method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
    	System.out.println(product);
    	productDao.createProduct(product);
    	RedirectView redirectView = new RedirectView();
    	redirectView.setUrl(request.getContextPath()+"/");
    	return redirectView;
    }
    
    @RequestMapping("/delete/{product_id}")
    public RedirectView deleteProduct(@PathVariable("product_id") int productId , HttpServletRequest request) {
    	this.productDao.delete(productId);
    	RedirectView redirectView = new RedirectView();
    	redirectView.setUrl(request.getContextPath()+"/");
    	return redirectView;
    }
    
   @RequestMapping("/update/{productId}") 
   public String updateForm(@PathVariable("productId") int pid, Model model) {
	   
	   Product product=this.productDao.getProduct(pid);
	   model.addAttribute("product", product);
	   return "update_form";
   }
   
   @RequestMapping(path ="/update-product/{productId}",method = RequestMethod.POST)
   public RedirectView updateFormDetails(@PathVariable("productId") int pid, @ModelAttribute Product product,HttpServletRequest request) {
	   product.setId(pid);
	   System.out.println(product);
	   this.productDao.update(product);
	   RedirectView redirectView = new RedirectView();
	   redirectView.setUrl(request.getContextPath()+"/");
	   return redirectView;
   }
   
}
