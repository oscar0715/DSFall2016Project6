package pit;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/*
 * You should NOT change any of this code.  All code changes should be done
 * ONLY in PITPlayerModel.java
 * 
 * All PITplayer# share identical code, except for three places:
 *  - the Queue that is being listened to (e.g. jms/PITplayer0)
 *  - the name of the class (e.g. PITplayer0)
 *  - the value of myPlayerNumber
 * 
 * These classes do not do any work.  Rather all interesting work is done in 
 * the PITPlayerModel, for which there is one for each PITplayer.
 * 
 */
@MessageDriven(mappedName = "jms/PITplayer0", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class PITplayer0 implements MessageListener {

    // Each PITplayer has a unique myPlayerNumber.  It should be the same as the Queue listened to.
    private final int myPlayerNumber = 0;

    private final PITPlayerModel myPlayerModel = new PITPlayerModel(myPlayerNumber);

    @Override
    public void onMessage(Message message) {
        //Pass the message onto the PITPlayerModel that implements the business (play) logic.
        myPlayerModel.onMessage(message);
    }
}