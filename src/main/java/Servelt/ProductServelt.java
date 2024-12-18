package Servelt;

import Mannager.productMannager;
import ProductModel.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/getAllProduct")
public class ProductServelt extends HttpServlet {
    productMannager productMannager = new productMannager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>All Products</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Product List</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        List<Product> products = productMannager.getAllProducts();
        try {
            products.stream().forEach(product -> {
                out.println("<tr>");
                out.println("<td>" + product.getId() + "</td>");
                out.println("<td>" + product.getName() + "</td>");
                out.println("<td>" + product.getPrice() + "</td>");
                out.println("</tr>");
            });
        }
        catch (Exception e) {
            response.sendRedirect("error?message=" + e.getMessage());
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
