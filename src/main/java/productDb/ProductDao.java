package productDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private Connection connection;
	
	private static final String SQL_SELECT_ALL = "SELECT product_id, product_name, price FROM products ORDER BY product_id";
	private static final String SQL_FIND_BYID = "SELECT * from products where product_id = ?";
	private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (? , ?)";
	private static final String SQL_UPDATE ="UPDATE products SET product_name = ?, price = ? where product_id = ?";
	private static final String SQL_DELETE = "DELETE FROM products WHERE product_name = ?";
	
	public ProductDao (Connection connection) {
		this.connection = connection;
		}
	
	public List<Product> findAll(){
		List<Product> list = new ArrayList<Product>();
		
		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)){
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				Product p = new Product(result.getInt("product_id"), result.getString("product_name"), result.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void register(Product product) {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)){
			
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getPrice());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Product findByProductId(Integer productId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_FIND_BYID)){
			
			stmt.setInt(1, productId);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				return new Product (result.getInt("product_id"), result.getString("product_name"), result.getInt("price"));
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public void update(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getPrice());
			stmt.setInt(3, product.getProductId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	 public void delete(String userName) {
	        try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
	            stmt.setString(1, userName);

	            stmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
