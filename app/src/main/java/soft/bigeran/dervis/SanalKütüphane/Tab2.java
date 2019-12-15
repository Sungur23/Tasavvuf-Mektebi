package soft.bigeran.dervis.SanalKütüphane;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Arrays;

import soft.bigeran.dervis.R;

public class Tab2 extends Fragment {
    //Overriden method onCreateView
    DatabaseReference mDatabse;
    RecyclerView recyclerView;
    Context ctx;
    ProgressDialog mProgressDialog;
    public static final String VIDEO_URL_KEY="key";
    public static final String VIDEO_TITLE_KEY="title_key";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sanalktab2, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.trending_video_list);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(gridLayoutManager);
        mDatabse = FirebaseDatabase.getInstance().getReference().child("Sanalkütüphane/yazarlar");
        mProgressDialog = new ProgressDialog(getActivity());





        return view;






    }

    @Override
    public void onStart() {
        super.onStart();
        Query trending = mDatabse.orderByChild("yazaradı");
        FirebaseRecyclerAdapter<Category_data, Tab2.VideoviewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Category_data, Tab2.VideoviewHolder>(

                Category_data.class,
                R.layout.sanalkcategory_item_style,
                Tab2.VideoviewHolder.class,
                trending


        ) {
            @Override
            protected void populateViewHolder(Tab2.VideoviewHolder viewHolder, final Category_data model, final int position) {



                viewHolder.setTitle(model.getYazaradı());
                viewHolder.setVideo(model.getYazarphotourl(), getContext());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Toast.makeText(getContext(),""+model.getVideo(),Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(getActivity(),Category_name.class);
                        intent.putExtra("Aktarılcak",model.getAktarılcak());

                        startActivity(intent);






                    }
                });

            }

        };


        recyclerView.setAdapter(firebaseRecyclerAdapter);








    }




    public static class VideoviewHolder extends RecyclerView.ViewHolder {
        View mView;

        public VideoviewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;

        }

        public void setTitle(String title_of_video){

            TextView video_title = (TextView)mView.findViewById(R.id.title_video_id);
            video_title.setText(title_of_video);

        }

        public void setVideo(String video_URl, Context context){

            ImageView videoView = (ImageView) mView.findViewById(R.id.video_view_id);
            final ProgressBar progressBar = (ProgressBar)mView.findViewById(R.id.image_loading_progress);

            RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.trendingloading);


            Glide.with(context).asBitmap().load(video_URl).listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).apply(options).into(videoView);



        }






    }











}