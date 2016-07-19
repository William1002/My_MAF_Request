package com.example.administrator.my_maf_request.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.my_maf_request.R;
import com.example.administrator.my_maf_request.bean.Subject;

import java.util.List;


public class MyListAdapter extends BaseAdapter {
    List<Subject> subjectList;
    Context context;
    LayoutInflater inflater;

    public MyListAdapter(List<Subject> subjectList, Context context) {
        this.subjectList = subjectList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return subjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Subject data = subjectList.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.subject_list_item, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_subject_item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(data.getTitle() + " " + "-" + " " + data.getShortName() + " " + "-" + " " + data.getNdCode());
        return convertView;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void setDataList(List<Subject> subjectCategoryList) {
        this.subjectList.clear();
        this.subjectList.addAll(subjectCategoryList);
        refresh();
    }

    class ViewHolder {
        TextView tvName;
    }
}
