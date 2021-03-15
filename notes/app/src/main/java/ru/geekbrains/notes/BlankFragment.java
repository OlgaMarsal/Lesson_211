package ru.geekbrains.notes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    private boolean isLandscape;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation
                = Configuration.ORIENTATION_LANDSCAPE;

        if(isLandscape) {
            showLandBlankFragmentTwo(0);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout)view;
        String[] notes = getResources().getStringArray(R.array.notes);

        Context context = getContext();
        for (int i = 0; i < notes.length; i++) {
            if (context != null) {
                String note = notes[i];
                TextView textView = new TextView(context);
                textView.setText(note);
                textView.setTextSize(30);
                layoutView.addView(textView);
                final int fi = i;
                textView.setOnClickListener(v -> showBlankFragmentTwo(fi));
            }
        }
    }

    private void showBlankFragmentTwo(int index) {
        if (isLandscape) {
            showLandBlankFragmentTwo(index);
        } else {
            showPortBlankFragmentTwo(index);
        }
    }

    private void showPortBlankFragmentTwo(int index) {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent(getActivity(), BlankFragmentTwo.class);
            intent.putExtra(BlankFragmentTwo.ARG_INDEX, index);
            startActivity(intent);
        }
    }


    private void showLandBlankFragmentTwo(int index) {
        BlankFragmentTwo detail = BlankFragmentTwo.newInstance(index);

        FragmentActivity context = getActivity();
        if (context != null) {
            FragmentManager fragmentManager = context.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.editTextOne, detail);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}