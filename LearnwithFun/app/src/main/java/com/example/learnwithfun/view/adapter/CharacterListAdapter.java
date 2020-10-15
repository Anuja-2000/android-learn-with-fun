package com.example.learnwithfun.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnwithfun.R;
import com.example.learnwithfun.util.LogUtil;
import com.example.learnwithfun.view.activity.SelectCharacterActivity;
import com.example.learnwithfun.view.fragment.PopupDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder> {
    private Context context;
    private String TAG = "adapter";
    private ArrayList<String> items = new ArrayList();
    private FragmentManager fragmentManager;
    public static int colourID;
    private SelectCharacterActivity selectCharacterActivity;


    public CharacterListAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public void setData(List<String> list) {
        items.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_component, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String character = items.get(position);
        LogUtil.error(TAG, "onBindViewHolder: " + character);
        holder.txtCharacter.setText(character);
        holder.cardView.setCardBackgroundColor(colourID);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.debug(TAG, "Selected Character = " + character);
                PopupDialogFragment dialogFragment = new PopupDialogFragment(character);
                dialogFragment.show(fragmentManager, "NB");
//                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetDialogFragment(character);
//                bottomSheetDialogFragment.show(fragmentManager,"NB");

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static void setColourID(int color) {
        colourID = color;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCharacter;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCharacter = itemView.findViewById(R.id.txt_characterName);
            cardView = itemView.findViewById(R.id.card_character);

        }
    }
}
