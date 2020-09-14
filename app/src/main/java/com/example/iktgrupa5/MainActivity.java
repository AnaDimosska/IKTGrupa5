package com.example.iktgrupa5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Item> list;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJson();
    }
    private void parseJson(){
        String url="https://pixabay.com/api/?key=18288458-f7b0750b55c0cf043dc692d5b&q=yellow+flowers&image_type=photo&pretty=true";
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray= response.getJSONArray("hits");
                            for( int i=0;i< jsonArray.length();i++){
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creatorName=hit.getString("user");
                                String imageURl=hit.getString("webformatURL");
                                int likes=hit.getInt("likes");
                                list.add(new Item(imageURl,creatorName,likes));

                            }
                            adapter = new Adapter(MainActivity.this, list);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
