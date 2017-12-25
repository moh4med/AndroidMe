package com.example.compucity.androidme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by CompuCity on 12/25/2017.
 */

public class BodyPartFragment extends Fragment {
    private static String TAG=BodyPartFragment.class.getSimpleName();
    private List<Integer> mImageIds;
    private int mListId;
    public BodyPartFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView)rootview.findViewById(R.id.body_part_image_view);
        if(mImageIds!=null) {
            imageView.setImageResource(mImageIds.get(mListId));
        }else{
            Log.v(TAG,"Fragment has null list of image");
        }
        return rootview;
    }

    public void setmListId(int mListId) {
        this.mListId = mListId;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }
}
