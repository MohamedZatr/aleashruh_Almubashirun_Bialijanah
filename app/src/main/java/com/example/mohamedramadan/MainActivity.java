package com.example.mohamedramadan;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOfList.communication {
//Create this variable to call this method communicator to get position is clicked
    FragmentOfList fragmentOfList;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        fragmentOfList = (FragmentOfList) manager.findFragmentById(R.id.fragment);
        fragmentOfList.communicator(this);
    }


    /**
     * This function send the position to Main2activity to send it to fragment of content
     * @param pos
     */
    @Override
    public void respond(int pos) {
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("pos",pos);
        startActivity(intent);
    }
}
