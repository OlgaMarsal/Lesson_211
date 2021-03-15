package ru.geekbrains.notes;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCrateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPopupMenu(view);
    }

    private void initPopupMenu(View view) {
        TextView text = view.findViewById(R.id.textView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = requireActivity();
                PopupMenu popupMenu = new PopupMenu(activity, v);
                activity.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                Menu menu = popupMenu.getMenu();
                menu.findItem(R.id.item2_pop).setVisible(false);
                menu.add(0, 123456, 12, R.string.new_menu_item_added);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.item1_pop:
                                Toast.makeText(getContext(), "Chosen popup item 1", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item2_pop:
                                Toast.makeText(getContext(), "Chosen popup item 2", Toast.LENGTH_SHORT).show();
                                return true;
                            case 123456:
                                Toast.makeText(getContext(), "Chosen new item added", Toast.LENGTH_SHORT).show();
                                return true;
                        }


                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}