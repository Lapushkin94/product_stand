package model;

import dto.ProductForStand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Named("productBean")
//@SessionScoped
public class ProductBean implements Serializable {

    private List<ProductForStand> productList;

    {
        ProductForStand productForStand = new ProductForStand();
        productForStand.setName("TestName");
        productForStand.setAuthor("TestAuthor");
        productForStand.setPrice(99);
        productList.add(productForStand);
    }

    public List<ProductForStand> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductForStand> productList) {
        this.productList = productList;
    }
}
