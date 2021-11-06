import com.example.dao.DaoProduct;
import com.example.model.Product;
import com.example.model.Supplier;
import com.example.service.ProductService;
import com.example.service.SupplierService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


//        Supplier supplier = new Supplier("Молочный комбинат", 25);
//        SupplierService supplierService = new SupplierService();
//        supplierService.saveInDataBase(supplier);

        Product product = new Product("Rbf", 15, "Молочный комбинат");


        ProductService productService = new ProductService();
        productService.saveInDataBase(product);
    }
}
