import service.MainPageService;
import service.ProductsService;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "MessageDrivenToProductUpdate", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class MessageDriver implements MessageListener {

    @EJB
    ProductsService productsService;

    @EJB
    MainPageService mainPageService;

    @PostConstruct
    @Override
    public void onMessage(Message message) {

        System.out.println("success");

        productsService.updateProducts();

//        mainPageService.refreshPage();

    }

}
