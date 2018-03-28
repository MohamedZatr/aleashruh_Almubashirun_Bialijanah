package com.example.mohamedramadan;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mohamed Ramadan on 17/01/2018.
 */

public class FragmentOfList extends Fragment implements AdapterView.OnItemClickListener {
    // Create Resources to get the string of ten item
    Resources  res;
    // Save the value from resource
    String name[];
    ListView listView;
    //Create this obj to send position of the item is clicked to review the content
    communication communicationl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // get the xml file
        View view=inflater.inflate(R.layout.list_fragment,container,false);
        // get resources to use string file
        res =getResources();
        name=res.getStringArray(R.array.frinds);

        ArrayAdapter adapter=new ArrayAdapter(getActivity(),R.layout.item_in_list,R.id.textlist,name);
        listView=view.findViewById(R.id.listf);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;

    }

    /**
     *
     * @param communication
     */
    public void communicator(communication communication)
{
    this.communicationl=communication;
}




// this method call when user click item
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            communicationl.respond(i);
    }




    // Create this Class to naviget the Value Between Tow Fragment
    interface communication
    {
        public void respond(int pos);
    }
}
