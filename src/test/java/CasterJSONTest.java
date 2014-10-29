import org.demoth.jcaster.CasterProtocol;
import org.demoth.jcaster.CasterProtocolJSON;
import org.demoth.jcaster.Game;
import org.demoth.jcaster.ServerWriter;
import org.demoth.jcaster.messages.CreatureMessage;
import org.demoth.jcaster.messages.EnvironmentMessage;
import org.demoth.jcaster.messages.EventMessage;
import org.demoth.jcaster.messages.InfoMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by demoth on 10/29/2014.
 */
public class CasterJSONTest {

    @Test
    public void testLogin() {
        StringBuilder buffer = new StringBuilder();
        Game testGame = new Game() {
            @Override
            public void updateEnvironment(EnvironmentMessage jsonMsg) {

            }

            @Override
            public void updateCreature(CreatureMessage jsonMsg) {

            }

            @Override
            public void updateInfo(InfoMessage jsonMsg) {

            }

            @Override
            public void updateEvent(EventMessage jsonMsg) {

            }
        };
        ServerWriter testServerWriter = buffer::append;
        CasterProtocol jsonp = new CasterProtocolJSON(testServerWriter, testGame);
        jsonp.login("doktor", "robotnik");
        Assert.assertEquals("{\"what\":\"login\",\"login\":\"doktor\",\"password\":\"robotnik\"}", buffer.toString());
    }
}
