package com.example.a1474672.colorvolleyproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MasterFragment extends Fragment{
        private RecyclerView recyclerView;
        private final String TAG = "mTag";
        RecyclerAdapter mAdapter;
        private List<Coloring> ColoringList = new ArrayList<>();
        private Context mCallback;
        ResponseHelper mResponseHelper;

        public static MasterFragment newInstance() {
            MasterFragment fragment = new MasterFragment();

            Log.i(fragment.TAG, "onCreateView MasterFragment");
            return fragment;
        }

        public void onAttach(Context context) {
            super.onAttach(context);
            Log.i(TAG, "onAttach");

            try {
                mCallback =  context;
            } catch (ClassCastException e) {
                throw new ClassCastException(context.toString()
                        + " must implement FragmentOneInterface");
            }
        }

        @Override
        public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup
                container, @Nullable Bundle savedInstanceState){
            mResponseHelper = new ResponseHelper();
            View mRootView = inflater.inflate(R.layout.fragment_main, container, false);
            recyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler);
            mAdapter = new RecyclerAdapter(ColoringList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager((Context)mCallback);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            return mRootView;

        }
        public void makeInternetRequest()
        {
            Log.i("clicked", "Internet Request");
            RequestQueue mRequestQueue = Volley.newRequestQueue((Context) mCallback);

            String url ="https://user.tjhsst.edu/2020ahuang/";

            // Request a string response from the provided URL.

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.i("RESPONSE", response);

                            Gson gson = new GsonBuilder().create();     // instantiate a gson builder
                            Coloring thisItem = gson.fromJson(response, Coloring.class);
                            Log.i("Coloring Item", "idnum: " + thisItem.getIdNumString());
                            Log.i("Coloring Item", "Color: " +thisItem.getMyColor());
                            Log.i("Coloring Item", "Number: " + thisItem.getNumberString());
                            ColoringList.add(thisItem);
                            mAdapter.notifyDataSetChanged();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("KOSEK", "error");
                }

            });
            mRequestQueue.add(stringRequest);
        }
        class ResponseHelper implements Response.Listener<String>, Response.ErrorListener {

            public ResponseHelper() {
            }

            @Override
            public void onResponse(String response) {
                Log.i("oh", response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("oh", "error");
            }

        }
    }
