package uk.ac.aber.dcs.cs31620.faaversion2.ui.kittens;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.ac.aber.dcs.cs31620.faaversion1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KittensFragment extends Fragment {


    public KittensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kittens, container, false);
    }

}
