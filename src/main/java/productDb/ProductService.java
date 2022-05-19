package productDb;

import java.sql.Connection;

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
}
