package productDb;

import java.sql.Connection;
import java.util.List;

import util.DbUtil;

	public class ProductService{
		public static Product dbSearch(Integer id) {
			Connection connection;
			ProductDao productDao;
			Product result = new Product();

			try{
				connection = DbUtil.getConnection();
				productDao = new ProductDao(connection);
				result = productDao.findByProductId(id);
				
				return result;
			}
			catch(RuntimeException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	public static List<Product> findAll() {
		Connection connection;
		ProductDao productDao;
		List<Product> result;

		try{
			connection = DbUtil.getConnection();
			productDao = new ProductDao(connection);
			result = productDao.findAll();
			
			return result;
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<Product> dbSearchByName(String productName) {
		Connection connection;
		ProductDao productDao;
		List<Product> result;

		try{
			connection = DbUtil.getConnection();
			productDao = new ProductDao(connection);
			result = productDao.findByName(productName);
			
			return result;
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Product> dbSearchByPrice(Integer price) {
		Connection connection;
		ProductDao productDao;
		List<Product> result;

		try{
			connection = DbUtil.getConnection();
			productDao = new ProductDao(connection);
			result = productDao.findByPrice(price);
			
			return result;
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Product> dbSearchByNameAndPrice(String productName,Integer price) {
		Connection connection;
		ProductDao productDao;
		List<Product> result;

		try{
			connection = DbUtil.getConnection();
			productDao = new ProductDao(connection);
			result = productDao.findByNameAndPrice(productName,price);
			
			return result;
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
}
