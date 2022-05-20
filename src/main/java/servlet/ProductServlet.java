package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productDb.Product;
import productDb.ProductService;
import util.ParamUtil;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productName = request.getParameter("product_name");
		String priceS = request.getParameter("price");
		String msg;
		System.out.println("productServlet");
		List<Product> result;
		
		if (!ParamUtil.isNullOrEmpty(productName) && !ParamUtil.isNullOrEmpty(priceS)){
			Integer price = Integer.parseInt(priceS);
			
					
			result = ProductService.dbSearchByNameAndPrice(productName, price);
			if (Objects.isNull(result)) {
				
			request.setAttribute("result", result);
			msg = "データを取得しました";
			
			}else {
				msg = "対象のデータはありません";
			}
				
				
		}else if(!ParamUtil.isNullOrEmpty(productName)) {
			
			result = ProductService.dbSearchByName(productName);
			if (Objects.isNull(result)) {
				
			request.setAttribute("result", result);
			
			msg = "データを取得しました";
			}else {
				msg = "対象のデータはありません";
			}
		}else if(!ParamUtil.isNullOrEmpty(priceS)) {
			Integer price = Integer.parseInt(priceS);
					
			result = ProductService.dbSearchByPrice(price);
			if ( result != null) {
				
			request.setAttribute("result", result);
			
			msg = "データを取得しました";
			}else {
				msg = "対象のデータはありません";
			}
			
		}else {
					
			result = ProductService.findAll();
			if (Objects.isNull(result)) {
				
			request.setAttribute("result", result);
			
			msg = "データを取得しました";
			}else {
				msg = "対象のデータはありません";
			}
		}
		 request.setAttribute("msg", msg);
		 
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

}
