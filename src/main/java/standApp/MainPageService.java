package standApp;

import javax.ejb.Singleton;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class MainPageService {

    @Inject
    @Push(channel = "push") // try another import
    private PushContext push;

    Logger logger = Logger.getLogger(MainPageService.class.getName());

    public void refreshPage() {
        logger.info("before push");
        push.send("updateProducts");
        logger.info("after push");
    }

}
