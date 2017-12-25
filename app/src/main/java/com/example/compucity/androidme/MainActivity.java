package com.example.compucity.androidme;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setmImageIds(ImageAssets.getHeads());
        headFragment.setmListId(3);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.head_container,headFragment)
                .commit();

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setmImageIds(ImageAssets.getBodies());
        bodyFragment.setmListId(3);
        fragmentManager.beginTransaction()
                .add(R.id.body_container,bodyFragment)
                .commit();

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setmImageIds(ImageAssets.getLegs());
        legFragment.setmListId(3);
        fragmentManager.beginTransaction()
                .add(R.id.leg_container,legFragment)
                .commit();
    }
}
