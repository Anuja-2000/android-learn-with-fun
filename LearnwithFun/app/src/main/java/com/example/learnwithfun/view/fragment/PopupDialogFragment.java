package com.example.learnwithfun.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.learnwithfun.R;
import com.example.learnwithfun.roomDataBase.entity.Words;
import com.example.learnwithfun.util.LogUtil;
import com.example.learnwithfun.view.adapter.DataListAdapter;
import com.example.learnwithfun.viewModel.ShowWordsViewModel;
import com.example.learnwithfun.repository.UserTimeRepo;
import com.rd.PageIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PopupDialogFragment extends DialogFragment {


    private RecyclerView recyclerView;
    private DataListAdapter dataListAdapter;
    private ShowWordsViewModel showWordsViewModel;
    private String character;
    private LinearLayoutManager linearLayoutManager;
    private TextView lblNext;
    private TextView lblPrevious;
    public int position;
    private ArrayList<Words> dataList = new ArrayList<>();
    private TextView txtCharacter;
    private TextView txtWord;
    private ImageView imageClose;
    private ImageView image;
    private Words data;
    private int arraySize;
    private GestureListener gestureListener;
    private LottieAnimationView lottieAnimationViewSwipeLeft;
    private LottieAnimationView lottieAnimationViewSwipeRight;
    private int index;
    private PageIndicatorView pageIndicatorView;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    private final int MAX_WATCH_FOR_STOP_GUIDE = 4;
    private boolean showGuide = false;

    public PopupDialogFragment() {
        // Required empty public constructor
    }

    public PopupDialogFragment(String character) {
        this.character = character;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container);
        image = view.findViewById(R.id.img_clip_art);
        final GestureDetector gestureDetector = new GestureDetector(new GestureListener());
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

        if (UserTimeRepo.getCount(getContext()) < MAX_WATCH_FOR_STOP_GUIDE) {
            showGuide = true;
        }
//        UserTimeRepo.setZero();

        lottieAnimationViewSwipeLeft = view.findViewById(R.id.animation_view_swipe_left);
        lottieAnimationViewSwipeRight = view.findViewById(R.id.animation_view_swipe_right);

        lottieAnimationViewSwipeLeft.setVisibility(View.GONE);
        lottieAnimationViewSwipeRight.setVisibility(View.GONE);

        pageIndicatorView = view.findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setVisibility(View.GONE);

        imageClose = view.findViewById(R.id.image_clip_art_close);

        txtWord = view.findViewById(R.id.lbl_word);

        lblNext = view.findViewById(R.id.lbl_next);
        lblNext.setVisibility(View.INVISIBLE);
        lblPrevious = view.findViewById(R.id.lbl_previous);
        lblPrevious.setVisibility(View.INVISIBLE);

        dataListAdapter = new DataListAdapter(getContext());

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        showWordsViewModel = new ViewModelProvider(this).get(ShowWordsViewModel.class);
        showWordsViewModel.getDataList(character).observe(getViewLifecycleOwner(), new Observer<List<Words>>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onChanged(List<Words> list) {
//                dataListAdapter.setData(list);
//                setData(list, view);
                gestureListener = new GestureListener();
                gestureListener.setDataOnGesture(view, list);
            }
        });
        position = 0;


        return view;
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = 650;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) layoutParams);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        super.onResume();
    }




    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                LogUtil.error("gesture", "r to l");
                if (position < arraySize - 1) {
                    position++;
                    setViews();

                }
                animationVisibilityValidation();
                return false; // Right to left
            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if (position != 0) {
                    position--;
                    setViews();
                }
                animationVisibilityValidation();
                return false; // Left to right
            }

            return false;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void setDataOnGesture(@NotNull View view, List<Words> list) {
            dataList.addAll(list);
            data = dataList.get(position);
            txtCharacter = view.findViewById(R.id.lbl_character);
            txtWord = view.findViewById(R.id.lbl_word);
            arraySize = dataList.size();
            txtCharacter.setText(data.getCharacter());
            txtWord.setText(data.getWord());
            index = data.getSplitIndex();
            makeTextBold(txtWord.getText().toString(), txtWord, index);
            image.setImageDrawable(getActivity().getDrawable(data.getImageID()));

            if (arraySize > 1 && showGuide) {
                lottieAnimationViewSwipeLeft.setVisibility(View.VISIBLE);
            }
            setPageIndicator();


        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void setViews() {
            data = dataList.get(position);
            txtCharacter.setText(data.getCharacter());
            txtWord.setText(data.getWord());
            index = data.getSplitIndex();
            makeTextBold(txtWord.getText().toString(), txtWord, index);
            image.setImageDrawable(getActivity().getDrawable(data.getImageID()));
            setPageIndicator();
        }

        private void animationVisibilityValidation() {

            if (showGuide) {
                if (position == arraySize - 1) {
                    lottieAnimationViewSwipeLeft.setVisibility(View.GONE);
                    lottieAnimationViewSwipeRight.setVisibility(View.VISIBLE);
                } else if (position == 0) {
                    lottieAnimationViewSwipeLeft.setVisibility(View.VISIBLE);
                    lottieAnimationViewSwipeRight.setVisibility(View.GONE);
                }
                if (arraySize == 1) {
                    lottieAnimationViewSwipeRight.setVisibility(View.GONE);

                }
            }

        }

        private void setPageIndicator() {
            if (arraySize > 1) {
                pageIndicatorView.setVisibility(View.VISIBLE);
            }
            pageIndicatorView.setCount(arraySize);
            pageIndicatorView.setSelection(position);
        }

    }

    public void setData(List<Words> list, @NotNull View view) {

        dataList.addAll(list);
        data = dataList.get(position);
        txtCharacter = view.findViewById(R.id.lbl_character);
        txtWord = view.findViewById(R.id.lbl_word);
        arraySize = dataList.size();
        txtCharacter.setText(data.getCharacter());
        txtWord.setText(data.getWord());
        image.setImageResource(data.getImageID());


        if (arraySize > 1) {
            lblNext.setVisibility(View.VISIBLE);
        }
        lblNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position++;
                data = dataList.get(position);
                txtCharacter.setText(data.getCharacter());
                txtWord.setText(data.getWord());
                image.setImageResource(data.getImageID());

                if (position == 0) {
                    lblPrevious.setVisibility(View.INVISIBLE);
                    lblNext.setVisibility(View.VISIBLE);
                } else if (position == arraySize - 1) {
                    lblPrevious.setVisibility(View.VISIBLE);
                    lblNext.setVisibility(View.INVISIBLE);
                } else {
                    lblPrevious.setVisibility(View.VISIBLE);
                    lblNext.setVisibility(View.VISIBLE);
                }

            }
        });


        lblPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position--;
                data = dataList.get(position);
                txtCharacter.setText(data.getCharacter());
                txtWord.setText(data.getWord());
                image.setImageResource(data.getImageID());

                if (position == 0) {
                    lblPrevious.setVisibility(View.INVISIBLE);
                    lblNext.setVisibility(View.VISIBLE);
                } else if (position == arraySize - 1) {
                    lblPrevious.setVisibility(View.VISIBLE);
                    lblNext.setVisibility(View.INVISIBLE);
                } else {
                    lblPrevious.setVisibility(View.VISIBLE);
                    lblNext.setVisibility(View.VISIBLE);
                }

            }
        });


    }

    public static void makeTextBold(String word, TextView textView, int index) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(word);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, 0, index, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //To make text Bold
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, index, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //To change color of text
        builder.append(spannableString);
        textView.setText(builder, TextView.BufferType.SPANNABLE);
    }
}


