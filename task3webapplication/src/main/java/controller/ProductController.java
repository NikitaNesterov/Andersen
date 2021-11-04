package controller;

import dao.DaoProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * @author Nikita Nesterov
 */
public class ProductController extends HttpServlet {
    
    private static final long SERIALVERSIONUID = 1L;
    private DaoProduct productDao = DaoProduct.getInstance();
    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Nothing created yet</h1>");
        writer.println("</html>");


    }
//        String action = request.getServletPath();
//        try{
//            switch (action){
//                case "/new product":
//                    showNewRegistrationFrom(request, response);
//                    break;
//                case "/insertProduct":
//                    insertProduct(request, response);
//                    break;
//                    case ""
//            }
//        }
//    }
//
//    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void showNewRegistrationFrom(HttpServletRequest request, HttpServletResponse response) {
//    }
}
