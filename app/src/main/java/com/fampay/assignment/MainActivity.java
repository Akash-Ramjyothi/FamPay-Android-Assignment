package com.fampay.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private LinearLayout hc6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        hc6 = findViewById(R.id.hc6_layout);
        String bgm = "#ff0000";
        hc6.setBackgroundColor(Color.parseColor(bgm));
        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }
    private void jsonParse() {
        String url = "https://run.mocky.io/v3/fefcfbeb-5c12-4722-94ad-b8f92caad1ad";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("card_groups");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(0);
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