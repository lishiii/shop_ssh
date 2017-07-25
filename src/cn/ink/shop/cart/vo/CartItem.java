package cn.ink.shop.cart.vo;

import cn.ink.shop.product.vo.Product;
/**
 * ���������
 * @author Ink4T
 *
 */
public class CartItem {
	private Product product; // ����������Ʒ��Ϣ
	private int count; // ����ĳ����Ʒ����
	private double subtotal; // ����ĳ����ƷС��

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// С���Զ������.
	public double getSubtotal() {
		return count * product.getShop_price();
	}
}
