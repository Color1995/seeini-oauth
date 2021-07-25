package com.seeini.common.utils;


import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author  Color2020
 */
public class OkHttpUtil {

    private static final Gson gson = new Gson();

    /**
     * Debug 模式
     * pdf 导出
     *
     * @param url
     * @param jsonParam
     * @param tenant
     * @param sign
     * @param timestamp
     * @param app_nonce
     * @return
     */
    public static String post2pdfSign(String url, String jsonParam, String authorization, String tenant, String timestamp, String app_nonce, String sign) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, jsonParam);

        String resultForJson = null;
        //设置媒体类型。application/json表示传递的是一个json格式的对象
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        //创建okHttpClient对象
        OkHttpClient okhttp = new OkHttpClient();
        //设置okhttp超时
        okhttp.newBuilder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(50000, TimeUnit.MILLISECONDS).build();
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(mediaType, jsonParam);

        Request request = new Request.Builder()
                .url(url)
                .method("POST", requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authorization)
                .addHeader("tenant", tenant)
                .addHeader("timestamp", timestamp)
                .addHeader("app-nonce", app_nonce)
                .addHeader("sign", sign)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String result = response.body().string();
                resultForJson = gson.toJson(result);
            } else {
                response = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.body().close();
        }

        return resultForJson;
    }

    public static String post2pdfSign2(String url, String jsonParam, String authorization, String tenant, String timestamp, String app_nonce, String sign) {


        String resultForJson = null;
        //设置媒体类型。application/json表示传递的是一个json格式的对象
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        //创建okHttpClient对象
        OkHttpClient okhttp = new OkHttpClient();
        //设置okhttp超时
        okhttp.newBuilder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(50000,TimeUnit.MILLISECONDS).build();
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(mediaType, jsonParam);
        //创建一个Request
        Request request = new Request.Builder().post(requestBody)
                .url(url)
                .method("POST", requestBody)
                .addHeader("Authorization", authorization)
                .addHeader("tenant", tenant)
                .addHeader("sign", sign)
                .addHeader("timestamp", timestamp)
                .addHeader("app-nonce", app_nonce)
                .addHeader("Content-Type", "application/json")
                .url(url).build();
        try {
            Response response = okhttp.newCall(request).execute();
            if(!response.isSuccessful())
                throw new IOException("unexpected code.."+response);
            String result = response.body().string();
            resultForJson = gson.toJson(result);
            response.body().close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultForJson;
    }

    public static String randomString(int len){

        String full = "abcdefhijkmnprstwxyz012345678";

        int maxPos = full.length();

        String app_nonce = "";
        for (int i = 0; i < len; i++) {
            app_nonce += full.charAt((int) Math.floor(Math.random() * maxPos));
        }


        return app_nonce;

    }
}
