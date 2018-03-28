package com.example.mohamedramadan;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {
FragmentOfContent fragmentOfContent;
FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // to get the position of item is clicked
        Intent intent=getIntent();
        int postion=intent.getIntExtra("pos",0);
        manager=getFragmentManager();
        fragmentOfContent = (FragmentOfContent) manager.findFragmentById(R.id.fragment1);
        //send the position is clicked to FragmentOfContent
        fragmentOfContent.change(postion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // get the Menu file
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this,Main3Activity.class));
        return super.onOptionsItemSelected(item);
    }
}
