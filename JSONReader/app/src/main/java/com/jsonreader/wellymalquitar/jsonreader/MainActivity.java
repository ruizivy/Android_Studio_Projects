package com.jsonreader.wellymalquitar.jsonreader;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    JsonParser jParser = new JsonParser();
    private static String locationPath = "http://maps.googleapis.com/maps/api/geocode/json?latlng=14.6715,121.93488&sensor=false";
    private String success;
    ArrayList<LocationDetails> locations = new ArrayList<>();
    private ListView listView1;
    private CustomListAdapter adapter;
    JSONArray myLocations = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);
        adapter = new CustomListAdapter(this, locations);
        listView1.setAdapter(adapter);

        new ShowAllUsers().execute();
    }
    
    private class ShowAllUsers extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Getting All users. Please wait...");
            dialog.setIndeterminate(false);
            dialog.setCancelable(false);
            dialog.show();
        }
        protected String doInBackground(String... params) {
            JSONObject json = jParser.makeHttpRequest(locationPath, "GET",
                    new ArrayList<NameValuePair>());
            try{
                 success = json.getString("status");
                if (success.equals("OK")){
                    myLocations = json.getJSONArray("results"); //-> result from SELECT query.
                    for(int i = 0; i < myLocations.length(); i++){
                        LocationDetails e = new LocationDetails();
                        JSONObject jObj = myLocations.getJSONObject(i);
                        JSONArray address_comp =  jObj.getJSONArray("address_components");
                        for(int j = 0; j < address_comp.length(); j++) {

                            JSONObject data = address_comp.getJSONObject(j);
                            String [] d = data.getString("types").split(",");
                            String longName = data.getString("long_name");
                            String typeName = d[0].replace("[","").replace("]","").replace("\"", "");

                            if (typeName.equals("street_number")) {
                                e.setStreet_number(longName);
                            }else if (typeName.equals("route")) {
                                e.setRoute(longName);
                            }else if(typeName.equals("neighborhood")) {
                                e.setNeighborhood(longName);
                            }else if(typeName.equals("locality")) {
                                e.setLocality(longName);
                            }else if(typeName.equals("country")) {
                                e.setCountry(longName);
                            }else if(typeName.equals("postal_code")){
                                e.setPostal_code(longName);
                            }
                        }
                        locations.add(e);
                    }
                }
                else{
                    showToast("No record found.");
                }
            }catch(Exception e){

                showToast("Network error. " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            runOnUiThread(new Runnable() {
                public void run() {
                    adapter = new CustomListAdapter(MainActivity.this, locations);
                    listView1.setAdapter(adapter);
                }
            });
        }
    }
    private void showToast(final String toast){
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MainActivity.this, toast, 3).show();
            }
        });
    }
}
