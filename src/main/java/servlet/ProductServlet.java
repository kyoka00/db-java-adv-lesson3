package servlet;

import java.io.IOException;

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
		String productIdS = request.getParameter("product_id");
		String msg;
		System.out.println("productServlet");
		
		
		if (!ParamUtil.isNullOrEmpty(productIdS)){
			Integer productId = Integer.parseInt(productIdS);
			Product p = new Product();
					
			p= ProductService.dbSearch(productId);
			if ( p != null) {
			int id = p.getProductId();
			request.setAttribute("id", id);
			
			String name = p.getProductName();
			request.setAttribute("name", name);
			
			int price = p.getPrice();
			request.setAttribute("price", price);
			
			msg = "データを取得しました";
			}else {
				msg = "対象のデータはありません";
			}
		}else {
			msg = "product_idを入力してください";
			
		}
		 request.setAttribute("msg", msg);
		 
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

}
