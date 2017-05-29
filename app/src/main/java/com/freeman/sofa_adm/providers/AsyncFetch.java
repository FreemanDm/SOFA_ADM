package com.freeman.sofa_adm.providers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.freeman.sofa_adm.R;
import com.freeman.sofa_adm.activity.CategoryList;
import com.freeman.sofa_adm.adapters.AdapterCategory;
import com.freeman.sofa_adm.model.CategoryTranslate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Freeman on 23.05.2017.
 */

public class AsyncFetch extends AsyncTask<String, String, String> {

//    private static final String TAG = "C";
    //        ProgressDialog pdLoading = new ProgressDialog();
    private HttpURLConnection conn;
    private URL url = null;
    private RecyclerView categoryList;
    private AdapterCategory adapterCategory;
    private Activity mActivity;

//    public AsyncFetch(){
//        adapterCategory = new AdapterCategory();
//    }


    public AsyncFetch(Activity activity) {
        this.mActivity = activity;
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            pdLoading.setMessage("\tLoading...");
//            pdLoading.setCancelable(false);
//            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                url = new URL("https://sofaapp.herokuapp.com/category/all");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            }
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(CategoryList.READ_TIMEOUT);
                conn.setConnectTimeout(CategoryList.CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                conn.setDoOutput(true);
            } catch (IOException e1) {
                e1.printStackTrace();
                return e1.toString();
            }
            try {
                int response_code = conn.getResponseCode();

                if (response_code == HttpURLConnection.HTTP_OK){
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine())!= null){
                        result.append(line);
                    }
                    return String.valueOf((result));
                }else {
                    return ("unsuccessful");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }

            ArrayList<CategoryTranslate> data = new ArrayList<>();
            String result;
            try{
                JSONArray jArray = new JSONArray(result);

                for (int i = 0; i < jArray.length(); i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    CategoryTranslate categoryTranslate = new CategoryTranslate();
                    categoryTranslate.setName(json_data.getString("name"));
                    data.add(categoryTranslate);
                }


//                DividerItemDecoration divader = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL);
//                categoryList.setLayoutManager(new LinearLayoutManager(mActivity));
//                categoryList.addItemDecoration(divader);
//                adapterCategory = new AdapterCategory(mActivity, data);
//                categoryList.setAdapter(adapterCategory);

            } catch (JSONException e) {
//                Toast.makeText(CategoryList.this, e.toString(), Toast.LENGTH_LONG).show();
//                Log.d(TAG,"Connected");
            }
        }

        @Override
        protected void onPostExecute(String result) {
//            pdLoading.dismiss();
//            ArrayList<CategoryTranslate> data = new ArrayList<>();

//            pdLoading.dismiss();
//            try{
//                JSONArray jArray = new JSONArray(result);
//
//                for (int i = 0; i < jArray.length(); i++){
//                    JSONObject json_data = jArray.getJSONObject(i);
//                    CategoryTranslate categoryTranslate = new CategoryTranslate();
//                    categoryTranslate.setName(json_data.getString("name"));
//                    data.add(categoryTranslate);
//                }
//
//                categoryList = (RecyclerView)findViewById(R.id.category_list);
//
                DividerItemDecoration divader = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL);
                categoryList.setLayoutManager(new LinearLayoutManager(mActivity));
                categoryList.addItemDecoration(divader);
                adapterCategory = new AdapterCategory();
                categoryList.setAdapter(adapterCategory);
//
//            } catch (JSONException e) {
//                Toast.makeText(CategoryList.this, e.toString(), Toast.LENGTH_LONG).show();
////                Log.d(TAG,"Connected");
//            }
        }
    }
