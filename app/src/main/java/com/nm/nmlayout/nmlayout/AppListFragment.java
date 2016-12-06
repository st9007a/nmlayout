package com.nm.nmlayout.nmlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AppListFragment extends Fragment {

    private ListView mListView;
    private List<App> appList = new ArrayList<App>();
    private AppAdapter adapter;

    public static AppListFragment newInstance(int position) {

        //set up fragment template !! important !!

        AppListFragment f = new AppListFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        appList.add(new App("Messager"));
        appList.add(new App("LINE"));
        appList.add(new App("Slack"));

        adapter = new AppAdapter(getActivity(), appList);
        mListView.setAdapter(adapter);

        return  view;
    }

    private class AppAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        private List<App> apps;

        public AppAdapter(Context context, List<App> apps){
            myInflater = LayoutInflater.from(context);
            this.apps = apps;
        }

        private class ViewHolder {
            TextView txtName;
            public ViewHolder(TextView txtName){
                this.txtName = txtName;
            }
        }

        @Override
        public int getCount() {
            return apps.size();
        }

        @Override
        public Object getItem(int index) {
            return apps.get(index);
        }

        @Override
        public long getItemId(int position) {
            return apps.indexOf(getItem(position));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = myInflater.inflate(R.layout.component_app_list_item, null);
                holder = new ViewHolder((TextView) convertView.findViewById(R.id.item_name));
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            App app = (App)getItem(position);
            holder.txtName.setText(app.getName());

            return  convertView;
        }
    }

    private class App {
        private Bitmap icon;
        private String name;

        public App() {
            name = "Messager";
        }

        public App(String name) {
            this.name = name;
        }

        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }

        public Bitmap getIcon() {
            return icon;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
