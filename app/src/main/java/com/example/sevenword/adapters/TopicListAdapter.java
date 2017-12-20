package com.example.sevenword.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sevenword.R;
import com.example.sevenword.data.models.Topic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TienBM on 12/16/2017.
 */
public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {

    private static final String TAG = TopicListAdapter.class.getSimpleName();
    private Context mContext;
    private List<Topic> mList;
    private OnItemClickListener mListener;

    public TopicListAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = new ArrayList<>();
        this.mListener = onItemClickListener;
    }

    public void setItems(List<Topic> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Topic item = mList.get(position);
        holder.tvTopicTitle.setText(item.getTitle());
        holder.tvTopicDes.setText(item.getDescription());
        Picasso.with(mContext)
                .load(item.getCover())
                .fit()
                .centerCrop()
                .into(holder.ivTopicCover);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Topic item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTopicCover;
        private TextView tvTopicTitle;
        private TextView tvTopicDes;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTopicCover = itemView.findViewById(R.id.ivTopicCover);
            tvTopicTitle = itemView.findViewById(R.id.tvTopicTitle);
            tvTopicDes = itemView.findViewById(R.id.tvTopicDes);
        }
    }
}