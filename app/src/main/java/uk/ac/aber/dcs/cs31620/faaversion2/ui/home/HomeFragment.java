package uk.ac.aber.dcs.cs31620.faaversion2.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import uk.ac.aber.dcs.cs31620.faaversion1.R;
import uk.ac.aber.dcs.cs31620.faaversion2.model.CatList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    CarouselView carouselView;
    CatList catList;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselView = view.findViewById(R.id.carouselView);
        catList = new CatList();
        // Hard-coded for now. Later on we will select based on last 5 cats
        // acquired
        carouselView.setPageCount(5);

        carouselView.setImageListener(imageListener);
        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(catList.getCats()[position].getResourceId());
        }
    };

}
