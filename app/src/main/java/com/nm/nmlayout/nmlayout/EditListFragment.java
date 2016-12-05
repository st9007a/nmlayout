package com.nm.nmlayout.nmlayout;

import android.content.Context;
import android.net.Uri;
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

public class EditListFragment extends Fragment {


    private ListView mListView;
    private List<String> groups = new ArrayList<String>();
    private EditListAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        groups.add("Work");
        groups.add("School");
        groups.add("Relax");

        adapter = new EditListAdapter(getActivity(), groups);
        mListView.setAdapter(adapter);

        return  view;
    }

    public class EditListAdapter extends BaseAdapter {

        private LayoutInflater myInflater;
        private List<String> groups;

        private class ViewHolder {
            TextView txtName;
            public ViewHolder(TextView txtName){
                this.txtName = txtName;
            }
        }

        public EditListAdapter(Context context, List<String> groups){
            myInflater = LayoutInflater.from(context);
            this.groups = groups;
        }

        @Override
        public int getCount() {
            return groups.size();
        }

        @Override
        public Object getItem(int index) {
            return groups.get(index);
        }

        @Override
        public long getItemId(int position) {
            return groups.indexOf(getItem(position));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = myInflater.inflate(R.layout.component_edit_list_item, null);
                holder = new ViewHolder(
                        (TextView) convertView.findViewById(R.id.item_name)
                );
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String groupName = (String)getItem(position);
            holder.txtName.setText(groupName);
            return  convertView;
        }
    }
}
