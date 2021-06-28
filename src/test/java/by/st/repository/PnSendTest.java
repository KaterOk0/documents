package by.st.repository;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;

// это пыталась отправлять пуши с/без прокси
public class PnSendTest {

    @Test
    public void send() throws IOException {
        String url = "https://fcm.googleapis.com/fcm/send";
        String request = "{\"to\":\"d8R93Ko56b0:APA91bFkXH_IwM_ZUxPAFsryq5TtAfuXVlUh09KQdGYQjHhflUZfgQZmvYeJ95OnhEpt0s3p5KyZ5ynq2y1OVFBetP4V9K4M4GtKhuadXXoxaJOQnVNsh2YZUU_tygTPejg8tGtTno3h\",\"data\":{\"queryId\":288746,\"type\":\"DOC_sign\",\"id\":14521,\"userId\":4121,\"company\":\"ОБЩЕСТ С ОГР ОТВЕТ \\\"ОЛИРИЯ КОНСАЛТ\",\"header\":\"Документ на подписание\",\"message\":\"Список | 50.50 BYN\"},\"time_to_live\":3540}";
        String request2 = "{\"to\":\"fx9Y0rQqKoU:APA91bHbyqdCvv9KvPaJXB2gPVWG4rTdlGqLiG2wwFT20m7UMR5IRci8RtWAXGTM7jiSMJjLHEYLvGyKa2xeWTInRcY2bYiYCk5IRqFV-gVB3GrFIKI-AaXBL2Yodjgh8ye9WOZU0VRC\",\"notification\":{\"title\":\"Документ на подписание\",\"body\":\"100.00 BYN | СИДОРОВ | НАЗНАЧЕНИЕ ПЛАТЕЖА\",\"click_action\":\"ACTION_DOC_sign\"},\"data\":{\"queryId\":308448,\"type\":\"DOC_sign\",\"id\":26631,\"userId\":12041,\"company\":\"ОАО Мобильный тест\"},\"time_to_live\":60,\"content_available\":true,\"priority\":\"high\"}\n";

        String reqBank = "{\"to\":\"fH64jaODp_M:APA91bEqKSPYsCdwjPlW6DvXuBqdAe18NVeW6-NNFVFCJhMLFoKFI4Q9xjzdrdvQw3mGoJ22Rz5S1nw8c4xu1hGUXMM8Nt-dVLyrXXqH4xasgnboT_U7VL0JE0x7f8buh1XYFFDhs32o\",\"notification\":{\"title\":\"Документ проведен\\r\",\"body\":\"Список | 2850.00 BYN\"},\"data\":{\"queryId\":16999680,\"type\":\"DOC_accept\",\"id\":63064,\"userId\":30332,\"company\":\"ЧАСТНОЕ ТРАНСПОРТНОЕ УНИТАРНОЕ ПРЕДПРИЯТИЕ \\\"ГРУЗМАШПАРТНЕР\\\"\"},\"time_to_live\":60,\"content_available\":true,\"priority\":\"high\"}";

        String key1 = "AAAAwsPJ69U:APA91bGOL69swqCDTffN6_cgrFAWr4tvxUMlTKoVGK3EAOJSajDHSBS-op5qxGCBYVyVfHJRRjOqcO3iR8FAqK1AmVBVdcb6Fb_iE_NyrnWhLxyl3DE0Z8Uh_kmNVL4fKfK0nkeSJy0C3HyXhtRNc_3Fkxo3bZgUNA";

        HttpURLConnection httpURLConnection = prepareHttpConnection(url, new String[]{"Content-Type", "application/json"},
                new String[]{"Authorization", "key=" + key1});

        httpURLConnection.getOutputStream().write(request.getBytes(StandardCharsets.UTF_8));
        httpURLConnection.getOutputStream().flush();
        httpURLConnection.connect();

        int respCode = httpURLConnection.getResponseCode();
        if (respCode != 200) {
            throw new IOException(respCode + " : " + httpURLConnection.getResponseMessage());
        }

        String responseData = getResponseData(httpURLConnection.getInputStream(), StandardCharsets.UTF_8.toString(), true);
        System.out.println(responseData);
    }

    private static String getResponseData(InputStream stream, String responseCharsetName, boolean withLineFeeds) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Reader is = new InputStreamReader(stream, responseCharsetName);
             BufferedReader bf = new BufferedReader(is)) {
            String line;

            while ((line = bf.readLine()) != null) {
                sb.append(line);
                if (withLineFeeds) {
                    sb.append("\r\n");
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return sb.toString();
    }

    private static HttpURLConnection prepareHttpConnection(String url, String[]... requestProps) throws IOException {
        URL reqUrl = new URL(url);
        HttpsURLConnection connection;
//        String myProxyHost = "10.57.41.41"; // REPLACE
//        int myProxyPort = 3128; // REPLACE

//        InetSocketAddress address = new InetSocketAddress(myProxyHost, myProxyPort);
        connection = (HttpsURLConnection) reqUrl.openConnection(Proxy.NO_PROXY);

        connection.setRequestMethod("POST");
        connection.setConnectTimeout(4000);
        connection.setReadTimeout(40000);

        connection.setDoInput(true);
        connection.setDoOutput(true);

        for (String[] props : requestProps) {
            connection.setRequestProperty(props[0], props[1]);
        }
        return connection;
    }
}
