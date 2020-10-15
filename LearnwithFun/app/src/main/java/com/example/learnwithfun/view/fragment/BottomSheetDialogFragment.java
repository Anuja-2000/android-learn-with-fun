package com.example.learnwithfun.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.learnwithfun.R;
import com.example.learnwithfun.roomDataBase.entity.Words;
import com.example.learnwithfun.view.adapter.DataListAdapter;
import com.example.learnwithfun.view.activity.SelectCharacterActivity;
import com.example.learnwithfun.viewModel.ShowWordsViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class BottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private RecyclerView recyclerView;
    private DataListAdapter dataListAdapter;
    private ShowWordsViewModel showWordsViewModel;
    private String character;
    private LinearLayoutManager linearLayoutManager;
    private TextView lblNext;
    private TextView lblPrevious;
    public int position;
    private SelectCharacterActivity selectCharacterActivity;
    private ViewPager viewPager;
    private ArrayList<Words> dataList = new ArrayList<>();
    private TextView txtCharacter;
    private TextView txtWord;
    private ImageView image;
    private Words data;

    public BottomSheetDialogFragment() {
    }

    public BottomSheetDialogFragment(String character) {
        this.character = character;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container);
//        dataListAdapter = new DataListAdapter(getContext());
//        recyclerView = view.findViewById(R.id.rv_word_list);
//        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(dataListAdapter);


        lblNext = view.findViewById(R.id.lbl_next);
        lblPrevious = view.findViewById(R.id.lbl_previous);
        lblPrevious.setVisibility(View.INVISIBLE);
//        FloatingActionButton fabCancel = view.findViewById(R.id.fab_close);
//        fabCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });

        showWordsViewModel = new ViewModelProvider(this).get(ShowWordsViewModel.class);
        showWordsViewModel.getDataList(character).observe(getViewLifecycleOwner(), new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> list) {
//                dataListAdapter.setData(list);
                setData(list, view);
            }
        });


//        View background = inflater.inflate(R.layout.activity_select_character, container);

        return view;
    }


    @Override
    public void onResume() {
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        getDialog().getWindow().setAttributes(layoutParams);
        position = 0;
//        lblNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                recyclerView.scrollToPosition(position + 1);
//                if (position == 1) {
//                    lblNext.setVisibility(View.INVISIBLE);
//                }
//            }
//        });
//
//        lblPrevious.setVisibility(View.INVISIBLE);
//        if (position == 2) {
//            lblPrevious.setVisibility(View.VISIBLE);
//        }

        super.onResume();
    }


    public void setData(List<Words> list, @NotNull View view) {
        dataList.addAll(list);
        data = dataList.get(position);
        txtCharacter = view.findViewById(R.id.lbl_character);
        txtWord = view.findViewById(R.id.lbl_word);
        image = view.findViewById(R.id.img_clip_art);
        final int arraySize = dataList.size();
        lblNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arraySize-1 != position){
                    lblNext.setVisibility(View.VISIBLE);
                }else {
                    lblNext.setVisibility(View.INVISIBLE);
                }
                if (arraySize-1> position) {
                    position++;
                    data = dataList.get(position);
                    txtCharacter.setText(data.getCharacter());
                    txtWord.setText(data.getWord());
                    image.setImageResource(data.getImageID());
                }
            }
        });
        txtCharacter.setText(data.getCharacter());
        txtWord.setText(data.getWord());
        image.setImageResource(data.getImageID());


        if (arraySize > 1) {
            lblNext.setVisibility(View.VISIBLE);
        }

    }

}
