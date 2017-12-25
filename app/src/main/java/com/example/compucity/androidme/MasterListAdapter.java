package com.example.compucity.androidme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CompuCity on 12/25/2017.
 */

public class MasterListAdapter extends BaseAdapter {
    private final List<Integer> mImageRes;
    Context mContext;

    public MasterListAdapter(Context context, List<Integer> imageres) {
        mContext = context;
        mImageRes = imageres;
    }

    @Override
    public int getCount() {
        return mImageRes.size();
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
        ImageView imageView;
        if(convertView==null){
            imageView=new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else{
            imageView= (ImageView) convertView;
        }
        imageView.setImageResource(mImageRes.get(position));
        return imageView;
    }
}
