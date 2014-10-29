package org.demoth.jcaster;

import org.demoth.jcaster.messages.CreatureMessage;
import org.demoth.jcaster.messages.EnvironmentMessage;
import org.demoth.jcaster.messages.EventMessage;
import org.demoth.jcaster.messages.InfoMessage;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

/**
 * Created by demoth on 10/26/2014.
 */
public class CasterProtocolJSON implements CasterProtocol {

    /*
     * String constants
     */
    public static final String WHAT        = "what";
    public static final String TYPE        = "type";
    public static final String INFO        = "info";
    public static final String LOGIN       = "login";
    public static final String PASSWORD    = "password";
    public static final String ACTION      = "action";
    public static final String ABOUT       = "about";
    public static final String ENVIRONMENT = "environment";
    public static final String CREATURE    = "creature";
    public static final String EVENT       = "event";

    /*
     * Components
     */
    private final ServerWriter serverWriter;
    private final Game         game;

    public CasterProtocolJSON(ServerWriter serverWriter, Game game) {
        this.serverWriter = serverWriter;
        this.game = game;
    }

    @Override
    public void login(String login, String password) {
        serverWriter.write(Json.createObjectBuilder()
                .add(WHAT, LOGIN)
                .add(LOGIN, login)
                .add(PASSWORD, password)
                .toString());
    }

    @Override
    public void action(Action type, Object params) {
        serverWriter.write(Json.createObjectBuilder()
                .add(WHAT, ACTION)
                .add(TYPE, type.name())
                .toString());
    }

    @Override
    public void info(Integer id) {
        serverWriter.write(Json.createObjectBuilder()
                .add(WHAT, INFO)
                .add(ABOUT, id)
                .toString());
    }

    @Override
    public void acceptMessage(String message) {
        JsonObject jsonMsg = Json.createReader(new StringReader(message)).readObject();
        switch (jsonMsg.getString(WHAT)) {
            case ENVIRONMENT:
                game.updateEnvironment(createEnvironmentMessage(jsonMsg));
                break;
            case CREATURE:
                game.updateCreature(createCreatureMessage(jsonMsg));
                break;
            case INFO:
                game.updateInfo(createInfoMessage(jsonMsg));
                break;
            case EVENT:
                game.updateEvent(createEventMessage(jsonMsg));
                break;
        }
    }

    private EventMessage createEventMessage(JsonObject jsonMsg) {
        // todo
        return null;
    }

    private InfoMessage createInfoMessage(JsonObject jsonMsg) {
        // todo
        return null;
    }

    private CreatureMessage createCreatureMessage(JsonObject jsonMsg) {
        // todo
        return null;
    }

    private EnvironmentMessage createEnvironmentMessage(JsonObject jsonMsg) {
        // todo
        return null;
    }
}
