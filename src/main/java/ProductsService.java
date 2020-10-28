import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Arrays;
import java.util.List;

//@Startup
@Singleton
public class ProductsService {

    private ProductBean productBean;

    @SuppressWarnings("unchecked")
    public void updateProducts() {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8888/showProductStand");
        List<ProductForStand> response = Arrays.asList(myResource.request().get(ProductForStand[].class));

        productBean.setProductList(response);

        client.close();

    }

    @Produces
    @Named
    public ProductBean getProductBean() {
        return productBean;
    }

}
