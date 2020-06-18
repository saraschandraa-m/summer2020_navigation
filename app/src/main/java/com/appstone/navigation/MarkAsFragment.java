package com.appstone.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MarkAsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mark_as_important, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvLabel = view.findViewById(R.id.tv_label);

        Button moveToArchiveButton = view.findViewById(R.id.btn_move_to_archive);

        Bundle data = getArguments();
        if (data != null) {
            String label = data.getString("LABEL");
            tvLabel.setText(label);
        }


        moveToArchiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo for moving from one fragment to another fragment in an activity
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArchiveFragment()).commit();


                //Todo to have a nested fragment.
                Bundle args = new Bundle();
                args.putString("LABEL", "ARCHIVE");

                ArchiveFragment archiveFragment = new ArchiveFragment();
                archiveFragment.setArguments(args);

                getChildFragmentManager().beginTransaction().replace(R.id.small_fragment_holder, archiveFragment).commit();


//                MainActivity activity = (MainActivity) getActivity();
//                activity.printToast();
            }
        });
    }
}
