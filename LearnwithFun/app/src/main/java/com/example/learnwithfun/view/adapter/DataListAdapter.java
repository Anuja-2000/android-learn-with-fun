package com.example.learnwithfun.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnwithfun.R;
import com.example.learnwithfun.roomDataBase.entity.Words;

import java.util.ArrayList;
import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {
    private ArrayList<Words> list = new ArrayList<>();
    private Context context;

    public DataListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Words> dataList) {
        list.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_example_rv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Words oneItem = list.get(position);
        holder.txtCharacter.setText(oneItem.getCharacter());
        holder.txtWord.setText(oneItem.getWord());
        holder.image.setImageResource(oneItem.getImageID());
//        BottomSheetDialogFragment.position = position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCharacter;
        private TextView txtWord;
        private ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCharacter = itemView.findViewById(R.id.lbl_character);
            txtWord = itemView.findViewById(R.id.lbl_word);
            image = itemView.findViewById(R.id.img_clip_art);

        }
    }
}
