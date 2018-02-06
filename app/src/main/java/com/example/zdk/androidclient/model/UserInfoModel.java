package com.example.zdk.androidclient.model;

import android.util.Log;

import com.example.zdk.androidclient.config.ServerConfiguration;
import com.example.zdk.androidclient.utils.HttpCallbackListener;
import com.example.zdk.androidclient.utils.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class UserInfoModel {
    public static void userLogin(String username,String password){
        try {
            username = URLEncoder.encode(username, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 如有中文一定要加上，在接收方用相应字符转码即可
        HttpUtil.sendHttpRequest("http://" + ServerConfiguration.IP + ":" +
                ServerConfiguration.PORT + ServerConfiguration.USERSERVICEURI +
                "login.action?name="+username+"&password="+password, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    int code = jsonObject.optInt("code");
                    if (code == 0){
                        //执行登录成功操作
                        Log.d("Tag",jsonObject.optString("msg"));
                    }else {
                        //执行登录失败操作
                        Log.d("Tag",jsonObject.optString("msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onError(Exception e) {
                Log.d("Tag","查询失败！");
            }
        });
    }
}
