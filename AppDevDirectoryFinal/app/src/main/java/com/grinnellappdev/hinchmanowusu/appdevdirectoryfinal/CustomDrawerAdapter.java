package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.Model.DrawerItem;

public class CustomDrawerAdapter extends BaseAdapter {

    Context context;
    List<DrawerItem> drawerItemList;

    public CustomDrawerAdapter(Context context, List<DrawerItem> listItems) {
        this.context = context;
        this.drawerItemList = listItems;
    }// CustomDrawerAdapter(Context, List<>

    @Override
    public int getCount() {
        return drawerItemList.size();
    }// getCount()

    @Override
    public Object getItem(int position) {
        return drawerItemList.get(position);
    }// getItem(int)

    @Override
    public long getItemId(int position) {
        return position;
    }// getItemId(int)

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        txtTitle.setText(drawerItemList.get(position).getTitle());

        return convertView;

    }// getView(int, View, ViewGroup)
}//class CustomDrawerAdapter