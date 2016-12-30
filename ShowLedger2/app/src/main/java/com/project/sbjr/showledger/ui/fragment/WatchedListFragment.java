package com.project.sbjr.showledger.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.sbjr.showinfodatabase.model.MovieModel;
import com.project.sbjr.showinfodatabase.model.TvShowModel;
import com.project.sbjr.showledger.R;


public class WatchedListFragment extends Fragment {
    private static final String USER_UID = "user_uid";
    private static final String SHOW_TYPE = "show_type";

    private String userUid;
    private String showType;

    private OnMovieWatchedFragmentInteractionListener mMovieListener;
    private OnTvShowWatchedFragmentInteractionListener mTvListener;

    public WatchedListFragment() {
        // Required empty public constructor
    }

    public static WatchedListFragment newInstance(String useruid, String showtype) {
        WatchedListFragment fragment = new WatchedListFragment();
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
        return inflater.inflate(R.layout.fragment_watched_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(showType.equalsIgnoreCase(MovieFragment.MOVIE_TAG)) {
            if (context instanceof OnMovieWatchedFragmentInteractionListener) {
                mMovieListener = (OnMovieWatchedFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnMovieWatchedFragmentInteractionListener");
            }
        }
        else {
            if (context instanceof OnTvShowWatchedFragmentInteractionListener) {
                mTvListener = (OnTvShowWatchedFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnTvShowWatchedFragmentInteractionListener");
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMovieListener = null;
    }

    public interface OnMovieWatchedFragmentInteractionListener {
        void onWatchedFragmentMovieItemOnClickListener(MovieModel movieModel);
    }

    public interface OnTvShowWatchedFragmentInteractionListener {
        void onWatchedFragmentTvShowItemOnClickListener(TvShowModel tvShowModel);
    }
}
