package brainathon;

import brainathon.components.EmailV2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String from,to,subject,body;
        EmailV2 email = (EmailV2) Naming.lookup("rmi://localhost:1099/email");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter From Email : ");
        from = s.nextLine();
        System.out.print("Enter To Email : ");
        to = s.nextLine();
        System.out.print("Enter the Subject : ");
        subject = s.nextLine();
        System.out.print("Enter the Body of Email : ");
        body = s.nextLine();
        email.sendEmail(from, to, subject, body);
    }
}
