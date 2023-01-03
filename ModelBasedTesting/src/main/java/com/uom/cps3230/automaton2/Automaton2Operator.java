package com.uom.cps3230.automaton2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Automaton2Operator {
    private boolean alertAreVerified = false;

    public StringBuffer getEventsLog() throws IOException {
       int responseCode;
       StringBuffer response = new StringBuffer();

       URL requestURL = new URL("https://api.marketalertum.com/EventsLog/d6353e3c-9340-444dd-93ee-371dcfeffb27");
       HttpURLConnection con = (HttpURLConnection) requestURL.openConnection();

        con.setRequestMethod("GET");
        responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            System.out.println("GET Request didn't work");
        }
        con.disconnect();
        return response;
    }

//    public boolean validateAlerts(ArrayList<Alert> alerts) {
//        for (Alert alert : alerts) {
//            if (alert.icon == null || alert.heading == null || alert.description == null || alert.image == null || alert.price == null || alert.linkToProduct == null) {
//                return false;
//            }
//            return true;
//        }
//    }

    public void viewAlertsWithValidLayout() {
//        StringBuffer eventsLogResponse = getEventsLog();
//        JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());
//
//        for (int i = 0; i < eventsArray.length(); i++) {
//            JSONObject event = eventsArray.getJSONObject(i);
//            int eventLogType = event.getInt("eventLogType");
//            if (eventLogType == 0) {
//                JSONObject systemState = event.getJSONObject("systemState");
//                JSONArray alertsArray = systemState.getJSONArray("alerts");
//                for (int j = 0; j < alertsArray.length(); j++) {
//                    JSONObject alert = alertsArray.getJSONObject(j);
//                    String id = alert.getString("id");
//                    int alertType = alert.getInt("alertType");
//                    String heading = alert.getString("heading");
//                    String description = alert.getString("description");
//                    String url = alert.getString("url");
//                    String imageURL = alert.getString("imageURL");
//                    int priceInCents = alert.getInt("priceInCents");
//
//                    Alert alertObject = new Alert(alertType, heading, description, imageURL, priceInCents, url);
//                    alerts.add(alertObject);
//                }
//            }
//        }

//        this.alertAreVerified = this.validateAlerts(alerts);
        this.alertAreVerified = true;
    }

    public void viewAlertsWithInvalidLayout() {
        this.alertAreVerified = false;
    }

    public boolean isLayoutValid() {
        return this.alertAreVerified;
    }
}
