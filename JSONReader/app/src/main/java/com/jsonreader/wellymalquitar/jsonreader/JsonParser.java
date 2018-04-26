package com.jsonreader.wellymalquitar.jsonreader;

/**
 * Created by wellymalquitar on 07/09/2017.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonParser {

    static InputStream inputStream = null;
    static JSONObject jsonObj = null;
    static String json = "";

    public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params){
        //Making HTTP Request
        try{
            if (method.equals("POST")){
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();

            }else if (method.equals("GET")){
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();
            }
        }catch(Exception ex){
        }

        try{
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, "iso-8859-1"), 8 );
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine())!= null){
                builder.append(line + "\n");
            }
            inputStream.close();
            json = builder.toString();
        }catch(Exception ex){
        }
        try{
            jsonObj = new JSONObject(json);
        }catch(Exception e){

        }
        return jsonObj;
    }
}
