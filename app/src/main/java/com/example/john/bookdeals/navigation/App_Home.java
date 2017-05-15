package com.example.john.bookdeals.navigation;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.john.bookdeals.App_Login;
import com.example.john.bookdeals.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@TargetApi(Build.VERSION_CODES.M)
public class App_Home extends Fragment implements RecyclerView.OnScrollChangeListener {

    private List<LoadData> listData1;

    //Creating Views
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    View v;
    //Volley Request Queue
    private RequestQueue requestQueue;

    //The request counter to send ?page=1, ?page=2  requests
    private int requestCount = 1;

    @TargetApi(Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_app__home, container, false);

        //Initializing Views
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        listData1 = new ArrayList<LoadData>();
        requestQueue = Volley.newRequestQueue(getContext());

        getData();

        //Adding an scroll change listener to recyclerview
        recyclerView.setOnScrollChangeListener(this);

        //initializing our adapter
        adapter = new CardAdapter(listData1, this);

        //Adding adapter to recyclerview

        return v;


    }



    private JsonArrayRequest getDataFromServer(int requestCount) {
        //Initializing ProgressBar
        final ProgressBar progressBar = (ProgressBar) v.findViewById(R.id.progressBar1);

        //Displaying Progressbar
        progressBar.setVisibility(View.VISIBLE);

        //JsonArrayRequest of volley

        //Returning the request
        return new JsonArrayRequest(Config.DATA_URL + String.valueOf(requestCount),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Calling method parseData to parse the json response
                        parseData(response);
                        //Hiding the progressbar
                        progressBar.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        //If an error occurs that means end of the list has reached
                        Toast.makeText(getContext(), "No More Items Available", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    //This method will parse json data
    private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            //Creating the superhero object
            LoadData loadData = new LoadData();
            JSONObject json;
            try {
                //Getting json
                json = array.getJSONObject(i);

                //Adding data to the superhero object
                loadData.setImageUrl(json.getString(Config.TAG_IMAGE));
                loadData.setTitle(json.getString(Config.TAG_TITLE));
                loadData.setPrice(json.getString(Config.TAG_PRICE));
                loadData.setCategory(json.getString(Config.TAG_CATEGORY));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Adding the superhero object to the list
            listData1.add(loadData);
        }

        //Notifying the adapter that data has been added or changed
        adapter.notifyDataSetChanged();
    }

    //This method would check that the recyclerview scroll has reached the bottom or not
    private boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if (recyclerView.getAdapter().getItemCount() != 0) {
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)
                return true;
        }
        return false;
    }


    //This method will get data from the web api
    private void getData() {
        //Adding the method to the queue by calling the method getDataFromServer
        requestQueue.add(getDataFromServer(requestCount));
        //Incrementing the request counter
        requestCount++;
    }

    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        //If scrolled at last then
        if (isLastItemDisplaying(recyclerView)) {
            //Calling the method getdata again
            getData();
        }

    }
}
