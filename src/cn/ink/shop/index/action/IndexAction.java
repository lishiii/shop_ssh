package cn.ink.shop.index.action;

import java.util.List;

import cn.ink.shop.category.service.CategoryService;
import cn.ink.shop.category.vo.Category;
import cn.ink.shop.product.service.ProductService;
import cn.ink.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	private CategoryService categoryService;
	private ProductService productService;
	
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 *
	 * ��ҳ��ת
	 * localhost:8080/shop/index
	 */
	@Override
	public String execute() throws Exception {
		
		// ����һ��Ŀ¼	
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getSession().put("cList", cList);
		// ����������Ʒ
		List<Product> hList = productService.findHot();
		ActionContext.getContext().getValueStack().set("hList", hList);
		// ����������Ʒ
		List<Product> nList = productService.findNew();
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
