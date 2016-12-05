package com.nm.nmlayout.nmlayout;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NotificationListFragment extends Fragment {

    private ListView mListView;
    private List<Notification> nList = new ArrayList<Notification>();
    private  NotificationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        nList.add(new Notification("JM Wu","hi","3:10"));
        nList.add(new Notification("CF Yarn","hello","3:12"));
        nList.add(new Notification("YY Lin","how are you","3:15"));
        nList.add(new Notification("JM Wu","hi","3:10"));
        nList.add(new Notification("CF Yarn","hello","3:12"));
        nList.add(new Notification("YY Lin","how are you","3:15"));
        nList.add(new Notification("JM Wu","hi","3:10"));
        nList.add(new Notification("CF Yarn","hello","3:12"));
        nList.add(new Notification("YY Lin","how are you","3:15"));
        nList.add(new Notification("JM Wu","hi","3:10"));
        nList.add(new Notification("CF Yarn","hello","3:12"));
        nList.add(new Notification("YY Lin","how are you","3:15"));

        adapter = new NotificationAdapter(getActivity(), nList);
        mListView.setAdapter(adapter);

        return view;
    }

    public class NotificationAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        private List<Notification> notifications;

        public NotificationAdapter(Context context,List<Notification> notification){
            myInflater = LayoutInflater.from(context);
            this.notifications = notification;
        }

        private class ViewHolder {
            TextView txtTitle;
            TextView txtText;
            TextView txtTime;
            public ViewHolder(TextView txtTitle, TextView txtText, TextView txtTime){
                this.txtTitle = txtTitle;
                this.txtText = txtText;
                this.txtTime = txtTime;
            }
        }

        @Override
        public int getCount() {
            return notifications.size();
        }

        @Override
        public Object getItem(int index) {
            return notifications.get(index);
        }

        @Override
        public long getItemId(int position) {
            return notifications.indexOf(getItem(position));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = myInflater.inflate(R.layout.component_notification_list_item, null);
                holder = new ViewHolder(
                        (TextView) convertView.findViewById(R.id.title),
                        (TextView) convertView.findViewById(R.id.text),
                        (TextView) convertView.findViewById(R.id.time)
                );
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Notification notification = (Notification)getItem(position);
            holder.txtTitle.setText(notification.getTitle());
            holder.txtText.setText(notification.getText());
            holder.txtTime.setText(notification.getPostTime());

            return  convertView;
        }
    }
}
