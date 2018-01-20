package com.example.poojajoshi.assignment_9_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{
    String [] names;
    String [] phoneNumbers;
    Context context;
    private static LayoutInflater inflater=null;

    // Create Custom Adapter
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, String[] prgmImages) {

        names = prgmNameList;
        context = mainActivity;
        phoneNumbers = prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView textView_name;
        TextView textView_phoneNo;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Create the each Row Item and fill with the name and number list

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_row, null);
        rowView.setMinimumHeight(200);
        rowView.setPadding(20, 5, 20, 5);

        holder.textView_name=(TextView) rowView.findViewById(R.id.textView1);
        holder.textView_phoneNo=(TextView) rowView.findViewById(R.id.textView2);

        holder.textView_name.setText(names[position]);
        holder.textView_phoneNo.setText(phoneNumbers[position]);

        return rowView;
    }

}