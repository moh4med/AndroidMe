package com.example.compucity.androidme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int headId;
    private int bodyId;
    private int legId;
    public static String HEADTAG="HEADID";
    public static String BODYTAG="BODYID";
    public static String LEGTAG="LEGID";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,AndroidMeActivity.class);
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
        getMenuInflater().inflate(R.menu.nextbutton,menu);
        return true;
    }

    @Override
    public void OnImageSelected(int position) {
        int bodypart=position/12;
        int id=position%12;
        switch (bodypart){
            case 0:
                headId=id;
                break;
            case 1:
                bodyId=id;
                break;
            case 2:
                legId=id;
                break;
        }
        Bundle b=new Bundle();
        b.putInt(HEADTAG,headId);
        b.putInt(BODYTAG,bodyId);
        b.putInt(LEGTAG,legId);
        intent.putExtras(b);
    }
}
