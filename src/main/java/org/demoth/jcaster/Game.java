package org.demoth.jcaster;

import org.demoth.jcaster.messages.*;

/**
 * Created by demoth on 10/27/2014.
 */
public interface Game {
    void updateEnvironment(EnvironmentMessage jsonMsg);

    void updateCreature(CreatureMessage jsonMsg);

    void updateInfo(InfoMessage jsonMsg);

    void updateEvent(EventMessage jsonMsg);
}
