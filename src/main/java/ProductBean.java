import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductBean implements Serializable {

    private List<ProductForStand> productList = new ArrayList<>();

    {
        ProductForStand productForStand = new ProductForStand();
        productForStand.setName("No data yet");
        productForStand.setPrice(0);
        productList.add(productForStand);
    }

}
