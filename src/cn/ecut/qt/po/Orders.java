package cn.ecut.qt.po;

import java.util.List;

/**
 * �����־û���
 */
public class Orders {
	private Integer id;    //����id
	private String number;//�������
	//������Ʒ������Ϣ
	private List<Product> productList;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
//	@Override
//	public String toString() {
//		return "Orders [id=" + id + ", number=" + number + "]";
//	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + ", productList=" + productList + "]";
	}
	
}
