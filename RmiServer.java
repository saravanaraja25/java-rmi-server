package brainathon;

import brainathon.components.EmailV2;
import brainathon.components.EmailV2Impl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) throws Exception {
        EmailV2 email = new EmailV2Impl();
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://localhost:1099/email", email);
        System.out.println("Server is Ready");
    }
}
