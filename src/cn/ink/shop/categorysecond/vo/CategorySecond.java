package cn.ink.shop.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import cn.ink.shop.category.vo.Category;
import cn.ink.shop.product.vo.Product;

/**
 * ���������ʵ��
 * @author ����.����
 *
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	// ����һ������.�����һ������Ķ���.
	private Category category;
	// ������Ʒ����
	private Set<Product> products = new HashSet<Product>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}