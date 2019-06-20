package com.ytjr.myapplication;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentListAdapter extends BaseAdapter {
    private Context context;
    private List<Student> datas;
    private LayoutInflater mInflater;

    public StudentListAdapter(Context context, List<Student> datas) {
        this.context = context;
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_student_list, null);
        }
        ViewHolder holder = getViewHolder(convertView);
        Student shop = datas.get(position);

        holder.tv_name.setText(shop.getName());
        holder.tv_percent.setText(shop.getPercent() + "");
        holder.tv_other.setText(shop.getStr() + "");
        return convertView;
    }

    /**
     * 获得控件管理对象
     *
     * @param view
     * @return
     */
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    /**
     * 控件管理类
     */
    private class ViewHolder {
        private TextView tv_name, tv_percent,tv_other;
        ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_percent = (TextView) view.findViewById(R.id.tv_percent);
            tv_other = (TextView) view.findViewById(R.id.tv_other);
        }
    }
}
