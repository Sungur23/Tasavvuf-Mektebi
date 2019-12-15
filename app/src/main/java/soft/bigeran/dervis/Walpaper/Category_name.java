package soft.bigeran.dervis.Walpaper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import soft.bigeran.dervis.R;

public class Category_name extends AppCompatActivity {
    Toolbar toolbar;
    DatabaseReference mDatabse;
    RecyclerView recyclerView;
    Context ctx;
    ProgressDialog mProgressDialog;
    public static final String VIDEO_URL_KEY="key";
    public static final String VIDEO_TITLE_KEY="title_key";
    public static final String CAT_KEY = "cat_key";
    public static final String SINGER_KEY = "singer_key";
    String gettingcatdata,current_cat="love",finalCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_name);


        Intent getIn = getIntent();
        gettingcatdata = getIn.getStringExtra(CAT_KEY);


        recyclerView = (RecyclerView)findViewById(R.id.single_cat_list);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(gridLayoutManager);
        mDatabse = FirebaseDatabase.getInstance().getReference().child("wallpapers");

        mProgressDialog = new ProgressDialog(getApplicationContext());

        if (gettingcatdata.equals("0")){

           current_cat = "genel dini";

        }
        else if(gettingcatdata.equals("1")){

           current_cat="tasavvuf";


        }
        else if(gettingcatdata.equals("2")){


           current_cat="buhara köyü";


        } else if(gettingcatdata.equals("3")){


            current_cat="diğer";


        }


    finalCat=current_cat.toLowerCase();

        Query categoryQuery = mDatabse.orderByChild("category").startAt(current_cat).endAt(current_cat+"\uf8ff");

        FirebaseRecyclerAdapter<Video_detail, Tab1.VideoviewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Video_detail, Tab1.VideoviewHolder>(

                Video_detail.class,
                R.layout.single_video,
                Tab1.VideoviewHolder.class,
                categoryQuery


        ) {
            @Override
            protected void populateViewHolder(Tab1.VideoviewHolder viewHolder, final Video_detail model, final int position) {



                // Toast.makeText(getActivity(),"MILGYA"+model.getSinger(),Toast.LENGTH_LONG).show();
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideo(model.getVideo(), getApplicationContext());





                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Toast.makeText(getContext(),""+model.getVideo(),Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(getApplicationContext(),Full_screen.class);
                        intent.putExtra(VIDEO_URL_KEY,model.getVideo());
                        intent.putExtra(VIDEO_TITLE_KEY,model.getTitle());

                        startActivity(intent);






                    }
                });

            }

        };


        recyclerView.setAdapter(firebaseRecyclerAdapter);




    }



}
