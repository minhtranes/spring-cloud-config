/*
 * Class: Test
 *
 * Created on Sep 14, 2018
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.configserver;

import java.io.InputStream;
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Test {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore","C:\\Users\\thminh_1\\Documents\\keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","Spsvn@123");
        
        String host = "git.spsvietnam.vn";
        int port = 443;
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory
                .getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory
                .createSocket(host, port);

            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();

            // Write a test byte to get a reaction :)
            out.write(1);

            while (in.available() > 0) {
                System.out.print(in.read());
            }
            System.out.println("Successfully connected");

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
