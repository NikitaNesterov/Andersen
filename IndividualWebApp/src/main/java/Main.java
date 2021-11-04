import com.example.dao.DaoProduct;
import com.example.model.Product;
import com.example.service.ProductService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


        Product product = new Product("Rbf", 15, "Ybrbnjc");

        ProductService productService = new ProductService();
        productService.saveInDataBase(product);
    }
}
