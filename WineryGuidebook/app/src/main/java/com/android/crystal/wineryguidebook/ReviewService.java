package com.android.crystal.wineryguidebook;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Crystal on 7/30/16.
 */
public class ReviewService {
    private String API_KEY;
    private final String TAG = getClass().getSimpleName();

    //Constructor
    public ReviewService(){this.API_KEY = "AIzaSyAy1kwW3Ja8NkKBCrMftJsrHwP7-IxtJ4U";}

    public ArrayList<Review> getReviews(String wineryId){
        String urlString = makeUrl(wineryId);
        try{
            String json = getJSON(urlString);
            System.out.println(json); // for log purpose
            JSONObject object = new JSONObject(json);
            JSONObject item = object.getJSONObject("result");
            JSONArray array = item.getJSONArray("reviews");

            ArrayList<Review> arrayList = new ArrayList<Review>();
            for(int i = 0; i<array.length();i++){
                try{
                    Review review = Review.jsonToPontoFreferencia((JSONObject) array.get(i));
                    arrayList.add(review);

                }catch(Exception e){
                    Log.e(TAG,e.getMessage());
                    System.out.println(e.getMessage());
                }
            }
            return arrayList;
        }catch(JSONException ex){
            Log.e(TAG + "JSON Exception:", ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private String makeUrl(String wineryId){
        StringBuilder urlString = new StringBuilder(
                //https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJ68MGgSSshYARiJdUvYSx6kY&key=AIzaSyAy1kwW3Ja8NkKBCrMftJsrHwP7-IxtJ4U
               "https://maps.googleapis.com/maps/api/place/details/json?"
        );
        urlString.append("placeid=");
        urlString.append(wineryId);
        urlString.append("&key="+API_KEY);

        System.out.println(urlString.toString());
        return urlString.toString();
    }

    protected String getJSON(String url){
        System.out.println(getUrlContents(url));
        return getUrlContents(url);
    }

    //fire the api call and read the result into String
    private String getUrlContents(String theUrl){
        StringBuilder content = new StringBuilder();
        try{
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()), 8);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                content.append(line + "\n");
            }
            bufferedReader.close();

        }catch(Exception e){
            Log.e(TAG,e.getMessage());
            e.printStackTrace();
        }
        return content.toString();
    }
}
