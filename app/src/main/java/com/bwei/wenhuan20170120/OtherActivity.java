package com.bwei.wenhuan20170120;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.bwei.wenhuan20170120.bean.Bean1;
import com.bwei.wenhuan20170120.bean.Rs;
import com.google.gson.Gson;

import java.util.List;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/20.
 * 描    述 ：
 * 修改时间 ：
 */


public class OtherActivity extends Activity {
    String url1 = "http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4";
    private ListView rvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        rvlist = (ListView) findViewById(R.id.rvlist);
        OkHttpUtil okHttpUtil = new OkHttpUtil();
        okHttpUtil.getJson(url1,new HttpData());
    }


  class HttpData extends OkHttpUtil.HttpCallBack {

      private MyAdapter adapter;

      @Override
      public void onSusscess(String data) {
          Gson gson=new Gson();
          Bean1 bean = gson.fromJson(data,Bean1.class);
          List<Rs> rs = bean.rs;
          getData(rs);
      }

      private void getData(List<Rs> rs) {

          adapter = new MyAdapter(rs,OtherActivity.this);
          rvlist.setAdapter(adapter);


      }
  }
}

