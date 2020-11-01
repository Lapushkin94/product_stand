package standApp;

import javax.ejb.Singleton;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class MainPageService {

    @Inject
    @Push
    private PushContext push;

    private Logger logger = Logger.getLogger(MainPageService.class.getName());

    public void refreshPage() {
        logger.info("pushing to jsf");
        push.send("updateProducts");
    }

}
