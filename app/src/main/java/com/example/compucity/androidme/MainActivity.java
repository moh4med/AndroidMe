package com.example.compucity.androidme;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int headId;
    private int bodyId;
    private int legId;
    public static String HEADTAG = "HEADID";
    public static String BODYTAG = "BODYID";
    public static String LEGTAG = "LEGID";
    private Intent intent;
    private boolean mtwoPane;
    private BodyPartFragment headFragment;
    private BodyPartFragment bodyFragment;
    private BodyPartFragment legFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, AndroidMeActivity.class);
        if (findViewById(R.id.android_me_linear_layout) != null) {
            Button button = (Button) findViewById(R.id.next_button);
            button.setVisibility(View.GONE);
            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            mtwoPane = true;
            if (savedInstanceState == null) {       //restore previous state
                //make head fragment
                headFragment = new BodyPartFragment();
                headFragment.setImageRes(ImageAssets.getHeads());
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();
                //make head fragment
                 bodyFragment = new BodyPartFragment();
                bodyFragment.setImageRes(ImageAssets.getBodies());
                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                //make head fragment
                 legFragment = new BodyPartFragment();
                legFragment.setImageRes(ImageAssets.getLegs());
                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        } else {
            mtwoPane = false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.next_button) {
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nextbutton, menu);
        return true;
    }

    @Override
    public void OnImageSelected(int position) {
        int bodypart = position / 12;
        int id = position % 12;

        if (mtwoPane) {
            switch (bodypart) {
                case 0:
                    headFragment.setImageId(id);
                    headFragment.changeImage();
                    break;
                case 1:
                   bodyFragment.setImageId(id);
                    bodyFragment.changeImage();
                    break;
                case 2:
                    legFragment.setImageId(id);
                    legFragment.changeImage();
                    break;
            }

        } else {
            switch (bodypart) {
                case 0:
                    headId = id;
                    break;
                case 1:
                    bodyId = id;
                    break;
                case 2:
                    legId = id;
                    break;
            }
            Bundle b = new Bundle();
            b.putInt(HEADTAG, headId);
            b.putInt(BODYTAG, bodyId);
            b.putInt(LEGTAG, legId);
            intent.putExtras(b);
        }
    }
}
