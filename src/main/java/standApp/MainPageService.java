package standApp;

import javax.ejb.Singleton;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;

@Singleton
public class MainPageService {

    @Inject
    @Push(channel = "push") // try another import
    private PushContext push;

    public void refreshPage() {
        push.send("updateProducts");
    }

}
