package com.bwei.wenhuan20170120;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.wenhuan20170120.bean.Rs;

import java.util.List;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/21.
 * 描    述 ：
 * 修改时间 ：
 */
public class MyAdapter extends BaseAdapter{
    private List<Rs> list;
    private Context mContext;

    public MyAdapter(List<Rs> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(mContext, R.layout.item, null);
        //获取布局item
        TextView tv1 = (TextView) convertView.findViewById(R.id.tv_item);
        tv1.setText(list.get(position).dirName);

        return convertView;
    }
}
