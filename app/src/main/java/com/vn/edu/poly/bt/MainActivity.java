package com.vn.edu.poly.bt;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<latest> latestList;
    LatestAdapter latestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getData();
    }

    private void initView() {
        rcV = (RecyclerView) findViewById(R.id.rcV);
    }

    private void getData() {



            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            String url = "https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=24bf810575bc5bfbe2aef1ed6cd4517b&user_id=63356846%40N04&format=json&nojsoncallback=1&extras=views,%20media,%20path_alias,%20url_sq,%20url_t,%20url_s,%20url_q,%20url_m,%20url_n,%20url_z,%20url_c,%20url_l,%20url_o&per_page=10&page=1";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("ketqua", response);
                            try {

                                ArrayList<latest> latests = new ArrayList<>();

                                JSONObject jsonObject = new JSONObject(response);

                                JSONObject jsonObjectP = jsonObject.getJSONObject("photos");
                                Log.d("photo", jsonObjectP.toString());


                                JSONArray jsonArrayS = jsonObjectP.getJSONArray("photo");
                                Log.d("photo2", jsonArrayS.toString());

                                for(int i=0 ; i<jsonArrayS.length();i++) {
                                    JSONObject jsonObjectQ = jsonArrayS.getJSONObject(i);
                                    Log.d("ddddd", jsonObjectQ.toString());

//                                    JSONObject jsonObjectA = jsonObjectQ.getJSONObject("url_sq");
//                                    Log.d("mmmmmm", jsonObjectQ.toString());

                                    String url = jsonObjectQ.getString("url_l");
                                    String a = jsonObjectQ.getString("title");
                                    Log.d("kkkkk", url);
                                    latests.add(new latest(url,a));




                                }
//
//
//
//


//                                    }
                                    mAdapter = new LatestAdapter(MainActivity.this,latests);
                                    rcV.setHasFixedSize(true);
                                    //mGridViewLatest.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                                    layoutManager = new GridLayoutManager(MainActivity.this,2);
                                    rcV.setLayoutManager(layoutManager);
                                    rcV.setAdapter(mAdapter);


//
//                                }




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
            requestQueue.add(stringRequest);




        }


    }
