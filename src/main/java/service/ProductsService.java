package service;

import dto.ProductForStand;
import model.ProductBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Startup
@Singleton
public class ProductsService {

    @EJB
    private ProductBean productBean;

    @SuppressWarnings("unchecked")
    public void updateProducts() {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://http://localhost:9990/");
        List<ProductForStand> response = Arrays.asList(myResource.request(MediaType.TEXT_PLAIN)
                .get(ProductForStand[].class));

//        productBean.setProductList(response);

        client.close();

    }

    @PostConstruct
    public void showBeanInfo() {
//        System.out.println(productBean.getProductList());
    }



}
