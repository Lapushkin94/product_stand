package standApp;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Logger;

@MessageDriven(name = "MessageDrivenToProductUpdate", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class MessageDriver implements MessageListener {

    @EJB
    ProductsService productsService;

    @EJB
    MainPageService mainPageService;

    private Logger logger = Logger.getLogger(MessageDriver.class.getName());

    @Override
    public void onMessage(Message message) {

        logger.info("service start updating products");
        productsService.updateProducts();
        logger.info("service end updating products");

        logger.info("service refresh start");
        mainPageService.refreshPage();
        logger.info("service refresh end");

    }

}
