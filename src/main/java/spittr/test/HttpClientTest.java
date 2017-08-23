package spittr.test;

import org.apache.http.impl.client.CloseableHttpClient;

import java.security.KeyStore;
import java.security.KeyStoreException;

/**
 * Created by zhaosy-c on 2017/7/28.
 */
public class HttpClientTest {

    public void junitTest(){
//        get();
    }

    public void ssl(){
        CloseableHttpClient httpClient = null;
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }
}
