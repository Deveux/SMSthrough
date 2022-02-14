package com.innosysit.smsthrough;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    ArrayList<ListData> items;
    Context context;

    public ListViewAdapter(ArrayList<ListData> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.sms_list, viewGroup, false);

        TextView viewFromPhoneNum = view.findViewById(R.id.fromPhoneNum);
        viewFromPhoneNum.setText(items.get(i).fromPhoneNum);

        TextView viewToPhoneNum = view.findViewById(R.id.toPhoneNum);
        viewToPhoneNum.setText(items.get(i).toPhoneNum);

        TextView viewDate = view.findViewById(R.id.date);
        viewDate.setText(items.get(i).date);

        TextView viewContents = view.findViewById(R.id.contents);
        viewContents.setText(items.get(i).contents);

        return view;
    }

}
