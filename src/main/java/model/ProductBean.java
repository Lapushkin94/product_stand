package model;

import dto.ProductForStand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Named("productBean")
@SessionScoped
public class ProductBean implements Serializable {

    private List<ProductForStand> productList = new ArrayList<>();

    {
        ProductForStand productForStand = new ProductForStand();
        productForStand.setName("No data yet");
        productForStand.setAuthor("No data yet");
        productForStand.setPrice(0);
        productList.add(productForStand);
    }

}
