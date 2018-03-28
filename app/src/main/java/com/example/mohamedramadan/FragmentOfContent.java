package com.example.mohamedramadan;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

/**
 * Created by Mohamed Ramadan on 17/01/2018.
 */

public class FragmentOfContent extends Fragment {
    // create TextView to review the title of content
    TextView name ;
    // create TextView to review the content
    static TextView content;
    Resources res;
    String names[],contents[];
    static float Size=0f;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_fragment,container,false);
        name=view.findViewById(R.id.txtitle);
        content=view.findViewById(R.id.txcontent);
        res=getResources();
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Size=DataSaved.getDataSaved(getActivity());
        if(Size<20)
        {
                return;
        }
        else
            content.setTextSize(Size);

    }

    /**
     * this method review the content of position is clicked
     * @param postion
     */
    public void change(int postion )
    {
        names=res.getStringArray(R.array.frinds);
        contents=res.getStringArray(R.array.contents);
        name.setText(names[postion]);
        content.setText(contents[postion]);
    }

    /**
     * change the size of text
     * @param size
     */
    public static void changetextSize(float size)
    {
            content.setTextSize(size);
    }
}
