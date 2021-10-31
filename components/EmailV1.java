package brainathon.components;

import java.rmi.Remote;

public interface EmailV1 extends Remote {
    public void sendEmail(String from, String to, String subject, String body) throws Exception;
}
