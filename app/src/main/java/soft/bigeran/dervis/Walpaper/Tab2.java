package soft.bigeran.dervis.Walpaper;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

import soft.bigeran.dervis.R;

public class Tab2 extends Fragment {

    DatabaseReference mDatabse;
    RecyclerView mRecyclerView,cateRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    String catNames[] = {
            "Genel Dini",
            "Tasavvuf",
            "Buhara Köyü",
        "Diğer",

    };
    String cat_image_urls[] = {
            "https://drive.google.com/uc?export=download&id=1O6nDmNiSoqwiEr5SSmLJmn_3Wro2ETr9",
            "https://drive.google.com/uc?export=download&id=1hMKPzQ5vm8eyL0wE2QSba307m-TdjZCr",
            "https://drive.google.com/uc?export=download&id=1qTQF1O9al7Ec3LEIW_CyHjbPALRndjhE",
            "https://drive.google.com/uc?export=download&id=1o5rU8nlZB8MBcyJdUblALVmxAw4ooWKw"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.Tab1 in you classes


        View v = inflater.inflate(R.layout.tab2, container, false);


        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)v.findViewById(R.id.horizontal_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        cateRecyclerview = (RecyclerView)v.findViewById(R.id.vertical_recyclerview);
        cateRecyclerview.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        cateRecyclerview.setLayoutManager(gridLayoutManager);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Category_data> catname  = prepareData();
        CategoryAdapter adapter = new CategoryAdapter(getActivity(),catname);



        cateRecyclerview.setAdapter(adapter);




        return v;
    }

    private ArrayList<Category_data> prepareData(){

        ArrayList<Category_data> android_version = new ArrayList<>();
        for(int i=0;i<catNames.length;i++){
            Category_data category_data = new Category_data();
            category_data.setCateName(catNames[i]);
            category_data.setCate_image_url(cat_image_urls[i]);
            android_version.add(category_data);
        }
        return android_version;
    }
}