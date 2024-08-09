package com.app.commerce.controller;

import com.app.commerce.entities.Product;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerDashboardController implements Initializable {

    Stage stage;
    @FXML
    Button customerLogOutBtn;
    @FXML
    ImageView productImage;
    @FXML
    ImageView productImage1;
    @FXML
    ImageView productImage2;
    @FXML
    Label productName;
    @FXML
    Label productPrice;
    @FXML
    Button addToCart;
    @FXML
    GridPane productGrid;

    ProductService productService = new ProductService();
    @FXML
    public void customerLogOut() throws IOException {
        Stage stage = (Stage) customerLogOutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Registration");
    }

    public void openNewPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerLogin/fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Customer Registration");
        newStage.setScene(scene);

        newStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/apple.png");
        Image image = new Image(file.toURI().toString());
        productImage.setImage(image);
        productImage1.setImage(image);
        productImage2.setImage(image);
        try {
            System.out.println(productService.getAllProduct());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadProduct() throws SQLException {
        File file = new File("images/apple.png");
        Image image = new Image(file.toURI().toString());
        List<Product> allProducts = productService.getAllProduct();
        int column = 0;
        int row = 0;

        for (Product product: allProducts){
            VBox productBox = new VBox();
            productImage.setImage(image);
        }
    }
}
