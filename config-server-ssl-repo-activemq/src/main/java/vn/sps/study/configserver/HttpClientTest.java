/*
 * Class: HttpClientTest
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpClientTest {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore","C:/Users/thminh_1/Documents/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","Spsvn@123");
        
//        System.setProperty("javax.net.ssl.keyStore","C:/Users/thminh_1/Documents/keystore.jks");
//        System.setProperty("javax.net.ssl.keyStorePassword","Spsvn@123");
//        System.setProperty("javax.net.ssl.keyStoreType","jks");
//        System.setProperty("com.sun.net.ssl.checkRevocation","false");
        
        System.out.println(System.getProperty("javax.net.ssl.trustStore")!=null);
        new HttpClientTest().testIt();
    }

    private void testIt() {
        String serviceUrl = "https://git.spsvietnam.vn/Research_And_Development/config-repo.git";
        URL url;
        try {

            url = new URL(serviceUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            //dumpl all cert info
            printHttpsCert(con);

            //dump all the content
            printContent(con);

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printHttpsCert(HttpsURLConnection con) {

        if (con != null) {

            try {

                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");

                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println(
                        "Cert Public Key Algorithm : "
                                + cert.getPublicKey().getAlgorithm());
                    System.out.println(
                        "Cert Public Key Format : "
                                + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }

            }
            catch (SSLPeerUnverifiedException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void printContent(HttpsURLConnection con) {
        if (con != null) {

            try {

                System.out.println("****** Content of the URL ********");
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

                String input;

                while ((input = br.readLine()) != null) {
                    System.out.println(input);
                }
                br.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
