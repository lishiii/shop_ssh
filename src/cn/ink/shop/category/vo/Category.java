package cn.ink.shop.category.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.ink.shop.categorysecond.vo.CategorySecond;

/**
 * һ�������ʵ�������
 * @author ����.����
 *
 */
public class Category implements Serializable{
	private Integer cid;
	private String cname;
	// һ�������д�Ŷ�������ļ���:
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}