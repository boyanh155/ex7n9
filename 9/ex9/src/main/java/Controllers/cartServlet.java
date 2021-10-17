package Controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.cart;
import Models.lineItem;
import Models.product;
import data.ProductIO;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/cart" })
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        //
        // String action = req.getParameter("action");
        String action = "cart";
        if (action == null) {
            action = "cart";
        }

        String url = "/index.jsp";
        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String pcode = req.getParameter("productCode");
            int qty = Integer.parseInt(req.getParameter("quantity"));

            HttpSession session = req.getSession();
            cart cart = (cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new cart();
            }
            int quantity;
            try {
                if (qty < 0)
                    qty = 1;
            } catch (NumberFormatException e) {
                qty = 1;
            }
            String path = sc.getRealPath("/WEB-INF/products.txt");
            product product = ProductIO.getProduct(pcode, path);

            lineItem lineItem = new lineItem();
            lineItem.setProduct(product);
            lineItem.setQty(qty);
            if (qty > 0) {
                cart.addItem(lineItem);
            } else if (qty == 0) {
                cart.removeItem(lineItem);
            }
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        } else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }
        if (url.equals("/index.jsp")) {
            sc.getRequestDispatcher(url).forward(req, resp);

        } else {
            sc.getRequestDispatcher("/WEB-INF/views/cart" + url).forward(req, resp);
        }
    }
}
