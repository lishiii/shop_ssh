package cn.ink.shop.product.action;

import java.util.List;

import cn.ink.shop.product.service.ProductService;
import cn.ink.shop.product.vo.Product;
import cn.ink.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	// ���ڽ������ݵ�ģ������.
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// ���շ���cid
	private Integer cid;

	// ���յ�ǰҳ��:
	private int page;
	// ���ն�������id
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * ��ѯ��Ʒ��ϸ��Ϣ
	 */
	public String findByPid() {
		// ����Service�ķ�����ɲ�ѯ.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	public String findByCid() {
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		// ����һ�������ѯ��Ʒ,����ҳ��ѯ
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ�������id��ѯ��Ʒ:
	public String findByCsid() {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}
