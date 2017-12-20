package com.example.sevenword.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sevenword.R;
import com.example.sevenword.data.models.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TienBM on 12/16/2017.
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private static final String TAG = WordListAdapter.class.getSimpleName();
    private Context mContext;
    private List<Word> mList;
    private OnItemClickListener mListener;

    public WordListAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = new ArrayList<>();
        this.mListener = onItemClickListener;
    }

    public void setItems(List<Word> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public List<Word> getList() {
        return mList;
    }

    public void removeItem(Word word, int pos){
        mList.remove(pos);
        notifyItemRemoved(pos);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         Word item = mList.get(position);

        holder.tvWordTitle.setText(item.getTitle());
        holder.tvWordMean.setText(item.getMean());
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder viewHolder = (ViewHolder) v.getTag();
                mListener.onItemClick(mList.get(viewHolder.getAdapterPosition()),viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Word item,int pos);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

       private TextView tvWordTitle;
       private TextView tvWordMean;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWordTitle = itemView.findViewById(R.id.tvWordTitle);
            tvWordMean = itemView.findViewById(R.id.tvWordMean);
        }
    }
}