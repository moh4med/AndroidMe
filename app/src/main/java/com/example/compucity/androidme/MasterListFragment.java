package com.example.compucity.androidme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by CompuCity on 12/25/2017.
 */

public class MasterListFragment extends Fragment {
    public MasterListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridview =(GridView) rootview.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter=new MasterListAdapter(getContext(),ImageAssets.getAll());
        gridview.setAdapter(masterListAdapter);
        return rootview;
    }
}
