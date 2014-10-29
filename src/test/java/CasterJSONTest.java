import org.demoth.jcaster.CasterProtocol;
import org.demoth.jcaster.CasterProtocolJSON;
import org.demoth.jcaster.ServerWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by demoth on 10/29/2014.
 */
public class CasterJSONTest {

    @Test
    public void testLogin() {
        StringBuilder buffer = new StringBuilder();
        ServerWriter testServerWriter = buffer::append;
        CasterProtocol jsonp = new CasterProtocolJSON(testServerWriter, null);
        jsonp.login("doktor", "robotnik");
        Assert.assertEquals("{\"what\":\"login\",\"login\":\"doktor\",\"password\":\"robotnik\"}", buffer.toString());
    }
}
