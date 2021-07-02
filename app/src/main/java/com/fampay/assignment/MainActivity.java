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

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private LinearLayout hc6;
    private ImageView hc6_img;
    private CardView clubforTeenagers;
    private CardView rewards;
    private CardView transactionsHistory;
    private CardView store;
    private CardView crdTransactions;
    private CardView crdRewards;

    private CardView savageRevenge;
    private CardView towerTwist;
    private CardView rocketMan;

    private CardView grumpyGorilla;

    private CardView addMoney;
    private Button cta_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        hc6 = findViewById(R.id.hc6_layout);
        clubforTeenagers = findViewById(R.id.club_for_teenagers_item);
        rewards = findViewById(R.id.club_for_teenagers_item2);
        transactionsHistory = findViewById(R.id.club_for_teenagers_item3);
        store = findViewById(R.id.club_for_teenagers_item4);
        crdTransactions = findViewById(R.id.crdTransactions);
        crdRewards = findViewById(R.id.crdRewards);

        savageRevenge = findViewById(R.id.savageRevenge);
        towerTwist = findViewById(R.id.towerTwist);
        rocketMan = findViewById(R.id.rocketMan);

        grumpyGorilla = findViewById(R.id.grumpyGorilla);

        addMoney = findViewById(R.id.addMoney);
        cta_btn = findViewById(R.id.cta_btn);

        jsonParse();

        crdTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://google.com/");
            }
        });

        crdRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtube.com/");
            }
        });

        clubforTeenagers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtube.com/");
            }
        });

        rewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://viserion.fampay.in/rewards/?fp_type\\u003dfpSurvey\\u0026fp_hide_bar\\u003dtrue\\u0026fp_bar_color\\u003d1f1f1f\\u0026tab\\u003d2\\u0026fp_ios_webview_type\\u003d2");
            }
        });

        transactionsHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://google.com/");
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://");
            }
        });

        hc6_img = findViewById(R.id.sca_iv_icon);
        Picasso.get()
                .load("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/128x128/plain/shape_square.png")
                .resize(90,90).into(hc6_img);

        hc6_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtube.com/");
            }
        });

        savageRevenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.gamezop.com/g/ry6bwfUt_Jg?id\\u003dbM14MfArj\\u0026fp_type\\u003dfpGame");
            }
        });

        towerTwist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.gamezop.com/g/HJT46GkPcy7?id\\u003dbM14MfArj\\u0026fp_type\\u003dfpGame");
            }
        });

        rocketMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.gamezop.com/g/SyXuN7W1F?id\\u003dbM14MfArj\\u0026fp_type\\u003dfpGame");
            }
        });

        grumpyGorilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.gamezop.com/g/N1sZfO1fWqg?id\\u003dbM14MfArj\\u0026fp_type\\u003dfpGame");
            }
        });

        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://facebook.com/");
            }
        });

        cta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://instagram.com/");
            }
        });

        //String bgm = "#000000";
        //hc6.setBackgroundColor(Color.parseColor(bgm));
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

                                }
                                else if (design_type.equals("HC3")==true){

                                }
                                else if (design_type.equals("HC5")==true){

                                }
                                else if (design_type.equals("HC6")==true){

                                }
                                else if (design_type.equals("HC9")==true){

                                }
                                else {

                                }

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