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
 * Created by Crystal on 7/27/16.
 * for calling google places api to return the winery list in Napa valley
 */
public class WineryService {
    private String API_KEY;
    private final String TAG = getClass().getSimpleName();

    //Constructor
    public WineryService(){this.API_KEY = "AIzaSyAy1kwW3Ja8NkKBCrMftJsrHwP7-IxtJ4U";}

    public ArrayList<Winery> findWineries(double latitude, double longitude, String placeSpacification){
        String urlString = makeUrl(latitude, longitude);
        try{
            String json = getJSON(urlString);
            System.out.println(json); // for log purpose
            //deserialize into arraylist of winery
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("results");
            ArrayList<Winery> arrayList = new ArrayList<Winery>();
            for(int i = 0; i<array.length();i++){
                try{
                    Winery winery = Winery.jsonToPontoFreferencia((JSONObject) array.get(i));
                    arrayList.add(winery);

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

    private String makeUrl(double latitude, double longitude){
        StringBuilder urlString = new StringBuilder(
                "https://maps.googleapis.com/maps/api/place/search/json?"
        );
        //fixed type to "winery" to search winery aroung Nape valley
        urlString.append("&location=");
        urlString.append(Double.toString(latitude));
        urlString.append(",");
        urlString.append(Double.toString(longitude));
        urlString.append("&radius=50000");
        urlString.append("&types=vineyards|wineries");
        urlString.append("&sensor=false&key="+ API_KEY);

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
