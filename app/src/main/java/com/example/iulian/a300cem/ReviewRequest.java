package com.example.iulian.a300cem;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sorin on 12/13/2016.
 */

public class ReviewRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://iulian.hostei.com/addMarker.php";
    private Map<String, String> params;

    public ReviewRequest (String title, String comment, Double longitude, Double latitude, Response.Listener<String> listener) {
        super (Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("title", title);
        params.put("comment", comment);
        params.put("longitude", longitude.toString());
        params.put("latitude", latitude.toString());
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

