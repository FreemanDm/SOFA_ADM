package com.freeman.sofa_adm.providers;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.freeman.sofa_adm.activity.CategoryList;
import com.freeman.sofa_adm.adapters.AdapterCategory;
import com.freeman.sofa_adm.model.CategoryTranslate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freeman on 23.05.2017.
 */

public class AsyncFetch extends AsyncTask<Void, Void, ArrayList<CategoryTranslate>> {

    private HttpURLConnection conn;
    private URL url = null;
    private AdapterCategory adapterCategory;
    private ProgressBar myProgress;


    public AsyncFetch(AdapterCategory adapterCategory,ProgressBar myProgress) {
        this.adapterCategory = adapterCategory;
        this.myProgress = myProgress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myProgress.setVisibility(View.VISIBLE);
    }

    @Override
    protected ArrayList<CategoryTranslate> doInBackground(Void... params) {
        ArrayList<CategoryTranslate> categories = null;
        try {
            url = new URL("https://sofaapp.herokuapp.com/category/all");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return categories;
        }
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(CategoryList.READ_TIMEOUT);
            conn.setConnectTimeout(CategoryList.CONNECTION_TIMEOUT);
            conn.setRequestMethod("GET");
        } catch (IOException e1) {
            e1.printStackTrace();
            return categories;
        }
        try {
            int response_code = conn.getResponseCode();

            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.d("MY_TAG", "doInBackground: result : " + result);
                Gson gson = new Gson();
                Type itemsListType = new TypeToken<List<CategoryTranslate>>() {
                }.getType();
                categories = gson.fromJson(result.toString(), itemsListType);
                return categories;
            } else {
                InputStream input = conn.getErrorStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.d("MY_TAG", "doInBackground: error server code : "+conn.getResponseCode() + " \nerror response : " + result);
                return categories;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return categories;
        } finally {
            conn.disconnect();
        }
    }

    @Override
    protected void onPostExecute(ArrayList<CategoryTranslate> result) {
        myProgress.setVisibility(View.GONE);
        if (result != null) {
            adapterCategory.updateList(result);
        }
    }
}
