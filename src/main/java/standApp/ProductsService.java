package standApp;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


@Singleton
public class ProductsService {

    Logger logger = Logger.getLogger(ProductsService.class.getName());
    private ProductBean productBean = new ProductBean();

    @SuppressWarnings("unchecked")
    public void updateProducts() {

        logger.info("creating client");
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8888/showProductStand");

        // try - catch response
        try {
            List<ProductForStand> response = Arrays.asList(myResource.request().get(ProductForStand[].class));
            productBean.setProductList(response);
        }
        catch (Exception exc) {
            logger.info(exc.getMessage());
        }

        client.close();

        logger.info("complete");
    }

    @Produces
    @Named
    public ProductBean getProductBean() {
        return productBean;
    }

    @PostConstruct
    public void getStartData() {

        logger.info("getting start data, creating client");
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8888/showProductStand");

        // try - catch response
        try {
            logger.info("try start");
            logger.info("getting array list");

            List<ProductForStand> response = Arrays.asList(myResource.request().get(ProductForStand[].class));

            logger.info("got array list + setting product bean");
            productBean.setProductList(response);
            logger.info("product bean added");
        }
        catch (Exception exc) {
            logger.info("fail: " + exc.getMessage());
        }

        client.close();

        logger.info("got start info");
    }

}
