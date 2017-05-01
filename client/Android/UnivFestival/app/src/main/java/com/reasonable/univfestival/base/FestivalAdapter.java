package com.reasonable.univfestival.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;
import com.reasonable.univfestival.R;
import com.reasonable.univfestival.UniversityDetailFragment;
import com.reasonable.univfestival.model.Festival;

import java.util.List;

/**
 * Created by jkimab on 2017. 4. 29..
 */

public class FestivalAdapter extends ParallaxRecyclerAdapter<Festival> implements AdapterInterface<Festival>{
    private Activity activity;
    private List<Festival> content;

    public FestivalAdapter(List<Festival> data, Activity activity) {
        super(data);
        this.activity = activity;
        this.content = data;
    }


    @Override
    public void onBindViewHolderImpl(RecyclerView.ViewHolder viewHolder, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
        Festival festival = content.get(i);
        RelativeLayout holder = ((RelativeLayout) viewHolder.itemView);
        ImageView universityLogo = (ImageView) holder.findViewById(R.id.university_logo);
        TextView univeristyTextView = (TextView) holder.findViewById(R.id.university_name);
        TextView festivalTextView = (TextView) holder.findViewById(R.id.festival_date);

        // TODO: change to fetching URL imageview, use Glide
        // universityLogo.setImageDrawable(); ((University) getData().get(i)).getImg_link();
        universityLogo.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.sample_logo));

        univeristyTextView.setText(festival.getUniversity_name());
        festivalTextView.setText(festival.getName());
        holder.setOnClickListener(v -> {
            FragmentManager manager = activity.getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.base_frame, UniversityDetailFragment.newInstance(festival.getExternalId()));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
        return new ViewHolder(activity.getLayoutInflater().inflate(R.layout.view_university_list, viewGroup, false));
    }

    @Override
    public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
        return content.size();
    }

    @Override
    public void addAll(List<Festival> list) {
        content.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public void add(Festival object) {
        content.add(object);
        notifyItemInserted(content.size());
    }

    @Override
    public void removeAll() {
        content.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}