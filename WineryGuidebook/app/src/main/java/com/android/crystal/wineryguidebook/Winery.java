package com.android.crystal.wineryguidebook;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

/**
 * Created by Crystal on 7/27/16.
 */
public class Winery implements Comparator<Winery>{
    private String id;
    private String icon;
    private String name;
    private String vicinity;
    private Double rate;
    private Double latitude;
    private Double longitude;
    //need to add reviews later

    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getIcon() {return icon;}
    public void setIcon(String icon){this.icon = icon;}
    public Double getLatitude(){return latitude;}
    public void setLatitude(Double latitude){this.latitude = latitude;}
    public Double getLongitude(){return longitude;}
    public void setLongitude(Double longitude){this.longitude = longitude;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getVicinity(){return vicinity;}
    public void setVicinity(String vicinity){this.vicinity = vicinity;}
    public Double getRate(){return rate;}
    public void setRate(String rate){this.rate = Double.parseDouble(rate);}

    static Winery jsonToPontoFreferencia(JSONObject pontoFeferencia) {
        try {
            Winery result = new Winery();
            JSONObject geometry = (JSONObject) pontoFeferencia.get("geometry");
            JSONObject location = (JSONObject) geometry.get("location");
            result.setLatitude((Double) location.get("lat"));
            result.setLongitude((Double) location.get("lng"));
            result.setIcon(pontoFeferencia.getString("icon"));
            result.setName(pontoFeferencia.getString("name"));
            result.setVicinity(pontoFeferencia.getString("vicinity"));
            result.setId(pontoFeferencia.getString("id"));
            if(pontoFeferencia.has("rating")) {
                result.setRate(pontoFeferencia.getString("rating"));
            }else{
                result.setRate("0");
            }
            return result;
        } catch (JSONException ex) {

        }
        return null;
    }

    @Override
    public int compare(Winery o1, Winery o2) {
        return o1.getRate().compareTo(o2.getRate());
    }

}
