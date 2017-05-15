package com.example.dana.muzej.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dana.muzej.R;

public class BookATourFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    Context context;

    public BookATourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_atour, container, false);
        context = rootView.getContext();

        Button buttonSendEmail = (Button) rootView.findViewById(R.id.sendEmail);
        buttonSendEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        return rootView;
    }

    protected void sendEmail() {
        Log.i("Send email", "");

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","amila_zimic@hotmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Book a tour");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear,\n\nWe would like to visit museum on DAY at TIME.\n\nRegards");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            getActivity().finish();
            Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
