package com.fampay.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Specifying the API to fetch the data
    public static final String API_DATA = "https://run.mocky.io/v3/fefcfbeb-5c12-4722-94ad-b8f92caad1ad";

    private TextView hc6Text;

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private LinearLayout hc6Layout;
    private ImageView hc6Img;
    private ImageView hc9Img;
    private ImageView hc1Img;
    private ImageView hc5Img;
    private ImageView hc3Img;

    private CardView rewards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hc6Text = findViewById(R.id.hc6Text);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        hc6Layout = findViewById(R.id.hc6_layout);

        rewards = findViewById(R.id.club_for_teenagers_item2);

        hc6Img = findViewById(R.id.hc6Icon);
        hc9Img = findViewById(R.id.clubforTeenagersImg);
        hc1Img = findViewById(R.id.hc1Img);

        jsonParse();

        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void jsonParse() {

        // Passing the URL;
        // String url = "https://run.mocky.io/v3/fefcfbeb-5c12-4722-94ad-b8f92caad1ad";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, API_DATA, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Iterating through JSON
                            JSONArray jsonArray = response.getJSONArray("card_groups");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String design_type = object.getString("design_type");

                                // Specifying w.r.t "design_type" to render views
                                if (design_type.equals("HC1")==true){
                                    JSONArray cards = object.getJSONArray("cards");
                                    JSONObject title = cards.getJSONObject(i);
                                    String hc1Title = title.getString("title");
                                    String hc1Icon = title.getString("image_url");
                                    String hc1Bgm = title.getString("bg_color");
                                    String hc1Url = title.getString("url");
                                    Picasso.get()
                                            .load(hc1Icon)
                                            .resize(90,90).into(hc1Img);
                                    rewards.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            gotoUrl(hc1Url);
                                        }
                                    });

                                }
                                else if (design_type.equals("HC3")==true){
                                    JSONArray cards = object.getJSONArray("cards");
                                    JSONObject title = cards.getJSONObject(i);
                                    String hc3Title = title.getString("title");
                                    String hc3Icon = title.getString("image_url");
                                    String hc3Bgm = title.getString("bg_color");
                                    String hc3Url = title.getString("url");
                                    Picasso.get()
                                            .load(hc3Icon)
                                            .resize(90,90).into(hc3Img);
                                    rewards.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            gotoUrl(hc3Url);
                                        }
                                    });

                                }
                                else if (design_type.equals("HC5")==true){
                                    JSONArray cards = object.getJSONArray("cards");
                                    JSONObject title = cards.getJSONObject(i);
                                    String hc5Title = title.getString("title");
                                    String hc5Icon = title.getString("image_url");
                                    String hc5Bgm = title.getString("bg_color");
                                    String hc5Url = title.getString("url");
                                    Picasso.get()
                                            .load(hc5Icon)
                                            .resize(90,90).into(hc5Img);
                                    rewards.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            gotoUrl(hc5Url);
                                        }
                                    });

                                }
                                else if (design_type.equals("HC6")==true){
                                    JSONArray cards = object.getJSONArray("cards");
                                    JSONObject title = cards.getJSONObject(i);
                                    String hc6Title = title.getString("title");
                                    String hc6Icon = title.getString("image_url");
                                    String hc6Bgm = title.getString("bg_color");
                                    String hc6Url = title.getString("url");
                                    hc6Text.setText(hc6Title);
                                    Picasso.get()
                                            .load(hc6Icon)
                                            .resize(90,90).into(hc6Img);
                                    hc6Layout.setBackgroundColor(Color.parseColor(hc6Bgm));
                                    hc6Img.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            gotoUrl(hc6Url);
                                        }
                                    });

                                }
                                else if (design_type.equals("HC9")==true){
                                    JSONArray cards = object.getJSONArray("cards");
                                    JSONObject title = cards.getJSONObject(i);
                                    String hc9Title = title.getString("title");
                                    String hc9Icon = title.getString("image_url");
                                    String hc9Bgm = title.getString("bg_color");
                                    String hc9Url = title.getString("url");
                                    Picasso.get()
                                            .load(hc9Icon)
                                            .resize(90,90).into(hc9Img);
                                    rewards.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            gotoUrl(hc9Url);
                                        }
                                    });
                                }
                                else {

                                }

                                // Used for Testing and Debugging
                                /*
                                Log.e("design_type",design_type);
                                String firstName = object.getString("name");
                                Log.e("firstName",firstName);
                                JSONArray cards = object.getJSONArray("cards");
                                JSONObject title = cards.getJSONObject(0);
                                String nm = title.getString("name");
                                Log.e("titlestr",nm);
                                JSONObject formatted = title.getJSONObject("formatted_title");
                                String text = formatted.getString("text");
                                Log.e("text",text);

                                int age = object.getInt("id");
                                String mail = object.getString("name");
                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                                */
                            }
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
        mQueue.add(request);
    }
}