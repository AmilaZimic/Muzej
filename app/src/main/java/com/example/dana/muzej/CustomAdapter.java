package com.example.dana.muzej;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        ImageView place_pic;
        TextView place_name;
        TextView street;
        TextView contactType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.place_name = (TextView) convertView
                    .findViewById(R.id.place_name);
            holder.place_pic = (ImageView) convertView
                    .findViewById(R.id.place_pic);
            holder.street = (TextView) convertView.findViewById(R.id.street);


            RowItem row_pos = rowItems.get(position);

            holder.place_pic.setImageResource(row_pos.getProfile_pic_id());
            holder.place_name.setText(row_pos.getMember_name());
            holder.street.setText(row_pos.getStatus());

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

}
