package productDb;

public class Product {
	private Integer productId;
	private String productName;
	private Integer price;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer product_id) {
		this. productId = product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String product_name) {
		this.productName = product_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Product() {
		
	}
	public Product(Integer productId, String productName, Integer price) {
		this. productId = productId;
		this.productName = productName;
		this.price = price;
	}
}
