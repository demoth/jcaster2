package org.demoth.jcaster;

/**
 * Created by demoth on 10/26/2014.
 */
public interface CasterProtocol {
    void login(String login, String pass);

    void action(Action type, Object params);

    void info(Integer id);

    void acceptMessage(String message);
}
