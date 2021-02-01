package ru.geekbrains.notes;

import android.content.res.TypedArray;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragmentTwo extends Fragment {

    static final String ARG_INDEX = 'index';
    private int index;

    public static BlankFragmentTwo newInstance(int index) {
        BlankFragmentTwo f = new BlankFragmentTwo();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExtractEditText editText1 = view.findViewById(R.id.editTextOne);
        TypedArray edittext = getResources().obtainTypedArray(R.array.notesWrite);
        editText1.setText(edittext.getResourceId(index, -1));
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExtractEditText editText1 = view.findViewById(R.id.editTextTwo);
        TypedArray edittext = getResources().obtainTypedArray(R.array.notesWrite);
        editText1.setText(edittext.getResourceId(index, -1));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExtractEditText editText1 = view.findViewById(R.id.editTextThree);
        TypedArray edittext = getResources().obtainTypedArray(R.array.notesWrite);
        editText1.setText(edittext.getResourceId(index, -1));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExtractEditText editText1 = view.findViewById(R.id.editTextFour);
        TypedArray edittext = getResources().obtainTypedArray(R.array.notesWrite);
        editText1.setText(edittext.getResourceId(index, -1));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExtractEditText editText1 = view.findViewById(R.id.editTextFive);
        TypedArray edittext = getResources().obtainTypedArray(R.array.notesWrite);
        editText1.setText(edittext.getResourceId(index, -1));
    }
}