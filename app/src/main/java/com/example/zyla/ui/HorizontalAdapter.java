package com.example.zyla.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zyla.Model.Artist;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    private static final String TAG = HorizontalAdapter.class.getSimpleName();
    private int viewCount = 2;
    private Context context;
    private Artist artist;

    HorizontalAdapter(Context context) {
        this.context = context;
    }

    public void refreshHorizontalData(Artist artist) {
        this.artist = artist;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item,parent, false);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(500, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(params);

        return new HorizontalViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
//        Log.i(TAG, "Hola " + Integer.toString(position) + " " + Integer.toString(viewCount));
        holder.populateView(position);

//        for (int i = 0; i < viewCount; i++) {
//            CardView cardView = ((CardView) holder.ll.getChildAt(i));
//            TextView textView = (TextView) cardView.getChildAt(0);
//            if(count < artist.getSongList().size()) {
//                textView.setText(artist.getSongList().get(count++));
//            }
//        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, artist.getSongList().size() + Integer.toString(viewCount));
        Log.i(TAG, Double.toString(Math.ceil(artist.getSongList().size() / viewCount)));
        return (int) Math.ceil((double) artist.getSongList().size() / (double) viewCount);
    }

    public void setViewCount(int count) {
        viewCount = count;
        this.notifyDataSetChanged();
//        Log.i(TAG, Integer.toString(viewCount));
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            ll = (LinearLayout) itemView;
        }

        // pass data as parameter
        public void populateView(int position) {
            ll.removeAllViews();
            for (int i = 0; i < viewCount && viewCount * position + i < artist.getSongList().size(); i++) {
                CardView cardView = new CardView(context);
                LinearLayout.LayoutParams cardParameter = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.WRAP_CONTENT);
                cardParameter.setMargins(50, 8, 8, 8);
                cardView.setLayoutParams(cardParameter);
                cardView.setContentPadding(8, 8, 8, 8);
                cardView.setCardElevation(4);

                TextView textView = new TextView(context);
//                if(viewCount*position + i < artist.getSongList().size()) {
                textView.setText(artist.getSongList().get(viewCount * position + i));
//                }
                LinearLayout.LayoutParams parameter = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                parameter.setMargins(50, 8, 8, 8);
                textView.setLayoutParams(parameter);
                cardView.addView(textView);
                ll.addView(cardView);
            }
        }
    }
}
