package com.example.compucity.androidme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CompuCity on 12/25/2017.
 */

public class BodyPartFragment extends Fragment {
    private static final String IMAGERESTAG = "IMAGERES";
    private static final String IMAGEIDTAG = "IMAGEID";
    private static String TAG=BodyPartFragment.class.getSimpleName();
    private List<Integer> ImageRes;
    private int ImageId;
    public BodyPartFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            setImageId(savedInstanceState.getInt(IMAGEIDTAG));
            setImageRes(savedInstanceState.getIntegerArrayList(IMAGERESTAG));
        }
        View rootview = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView)rootview.findViewById(R.id.body_part_image_view);
        if(ImageRes !=null) {
            imageView.setImageResource(ImageRes.get(ImageId));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageId = (ImageId + 1) % ImageRes.size();
                    imageView.setImageResource(ImageRes.get(ImageId));
                }
            });
        }else{
            Log.v(TAG,"Fragment has null list of image");
        }
        return rootview;
    }

    public void setImageId(int imageId) {
        this.ImageId = imageId;
    }

    public void setImageRes(List<Integer> imageRes) {
        this.ImageRes = imageRes;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGERESTAG, (ArrayList<Integer>) ImageRes);
        outState.putInt(IMAGEIDTAG,ImageId);
        super.onSaveInstanceState(outState);
    }
}
