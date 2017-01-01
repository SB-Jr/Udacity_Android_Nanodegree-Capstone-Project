package com.project.sbjr.showledger.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.sbjr.showinfodatabase.model.TvShowModel;
import com.project.sbjr.showledger.R;


public class IncompleteListFragment extends Fragment {
    private static final String USER_UID = "user_uid";
    private static final String SHOW_TYPE = "show_type";

    // TODO: Rename and change types of parameters
    private String userUid;
    private String showType;

    private OnIncompleteFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private TextView mErrorTextView;

    public IncompleteListFragment() {
        // Required empty public constructor
    }

    public static IncompleteListFragment newInstance(String useruid, String showtype) {
        IncompleteListFragment fragment = new IncompleteListFragment();
        Bundle args = new Bundle();
        fragment.userUid = useruid;
        fragment.showType = showtype;
        args.putString(USER_UID, useruid);
        args.putString(SHOW_TYPE, showtype);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userUid = getArguments().getString(USER_UID);
            showType = getArguments().getString(SHOW_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_incomplete_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.contents);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        mErrorTextView = (TextView) view.findViewById(R.id.error_text);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(userUid).child("tvshows").child("incomplete");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    public void initListener(Fragment fragment) {
        if (fragment instanceof OnIncompleteFragmentInteractionListener) {
            mListener = (OnIncompleteFragmentInteractionListener) fragment;
        } else {
            throw new RuntimeException(fragment.toString()
                    + " must implement OnIncompleteFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnIncompleteFragmentInteractionListener {
        void onIncompleteFragmentItemClickListener(TvShowModel tvShowModel);
    }
}
