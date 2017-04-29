package com.reasonable.univfestival;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jkimab on 2017. 4. 29..
 */

public class UniversityDetailFragment extends Fragment {
    private static final String UNIVERSITY_ID_KEY = "university_id";
    private long universityKey;

    public static UniversityDetailFragment newInstance(final long universityId) {
        UniversityDetailFragment fragment = new UniversityDetailFragment();
        Bundle args = new Bundle();
        args.putLong(UNIVERSITY_ID_KEY, universityId);
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_university_detail, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            universityKey = bundle.getLong(UNIVERSITY_ID_KEY, -1);
        }
        return view;
    }


}
