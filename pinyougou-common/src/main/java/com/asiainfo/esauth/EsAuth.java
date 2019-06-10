package com.asiainfo.esauth;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class EsAuth {

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = getHttpClient("elastic", "changeme");
        String url = "http://10.1.234.16:8200/_search?pretty";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
        HttpResponse response = httpClient.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity());
        System.out.println(s);
    }

    public static CloseableHttpClient getHttpClient(String username, String password){
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username,password);
        provider.setCredentials(AuthScope.ANY, credentials);
        return  HttpClients.custom().setDefaultCredentialsProvider(provider).build();
    }
}
