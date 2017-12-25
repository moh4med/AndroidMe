package com.example.compucity.androidme;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {       //restore previous state
            //make head fragment
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageRes(ImageAssets.getHeads());
            headFragment.setImageId(3);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            //make head fragment
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageRes(ImageAssets.getBodies());
            bodyFragment.setImageId(3);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            //make head fragment
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageRes(ImageAssets.getLegs());
            legFragment.setImageId(3);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
