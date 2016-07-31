package com.android.crystal.wineryguidebook;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Crystal on 7/30/16.
 */
public class Review {
    private String rate;
    private String authorName;
    private String text;

    public String getRate(){return rate;}
    public void setRate(String rate){this.rate = rate;}
    public String getAuthorName(){return authorName;}
    public void setAuthorName(String autherName){this.authorName = autherName;}
    public String getText(){return text;}
    public void setText(String text){this.text = text;}

    static Review jsonToPontoFreferencia(JSONObject pontoFeferencia) {
        try {
            Review result = new Review();
            result.setRate(pontoFeferencia.getString("rating"));
            result.setAuthorName(pontoFeferencia.getString("author_name"));
            result.setText(pontoFeferencia.getString("text"));
            return result;
        } catch (JSONException ex) {

        }
        return null;
    }
}
