package com.app.commerce.controller;

import com.app.commerce.entities.Cart;
import com.app.commerce.entities.Customer;
import com.app.commerce.entities.Order;
import com.app.commerce.entities.Product;
import com.app.commerce.services.CartService;
import com.app.commerce.services.CustomerService;
import com.app.commerce.services.OrderService;
import com.app.commerce.services.ProductService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerDashboardController implements Initializable {

    @FXML
    private Button customerLogOutBtn;
    @FXML
    private GridPane productGrid;

    @FXML
    Button viewCartBtn;
    @FXML
    Button orderHistoryBtn;

    private final ProductService productService = new ProductService();


    @FXML
    public void viewCart() throws SQLException, IOException {
        Stage stage = (Stage) viewCartBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/ViewCart.fxml")));
        stage.setScene(new Scene(root, 900, 600));
        stage.setTitle("Cart");
    }

    @FXML
    public void customerLogOut() throws IOException {
        Stage stage = (Stage) customerLogOutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Registration");
    }

    @FXML
    public void orderHistory() throws SQLException, IOException {
        Stage stage = (Stage) customerLogOutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerViewOrders.fxml")));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Order History");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProducts() throws SQLException {
        List<Product> allProducts = productService.getAllProduct();
        int column = 0;
        int row = 0;

        for (Product product : allProducts) {
            VBox productBox = createProductBox(product);
            productGrid.add(productBox, column, row);

            column++;
            if (column == 3) {
                column = 0;
                row++;
            }
        }
    }

    private VBox createProductBox(Product product) {
        VBox productBox = new VBox();

        ImageView productImage = new ImageView();
        File file = new File("images/apple.png"); // Replace with actual product image path
        Image image = new Image(file.toURI().toString());
        productImage.setImage(image);
        productImage.setFitHeight(150);
        productImage.setFitWidth(200);
        productImage.setPreserveRatio(true);

        Label productName = new Label(product.getProductName());
        Label productPrice = new Label("$" + product.getProductPrice());

        Button addToCartButton = new Button("Add to cart");
        addToCartButton.setFont(new javafx.scene.text.Font("Arial Rounded MT Bold", 15));

        addToCartButton.setOnAction(event -> {
            try {
                addProduct(product.getProductId(), CustomerService.customerId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        productBox.getChildren().addAll(productImage, productName, productPrice, addToCartButton);

        return productBox;
    }

    public void addProduct(int  productId, int customerId) throws SQLException {
        CartService cartService = new CartService();
        Cart cart = new Cart(productId, customerId);
        cartService.addProductToCart(cart);
    }


}
