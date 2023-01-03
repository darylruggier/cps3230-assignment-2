package com.uom.cps3230.automaton1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Automaton1Operator {
    private boolean loggedIn = false, loggedOut = true;

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

    public void validLogin() throws IOException {
        StringBuffer eventsLogResponse = getEventsLog();
//        JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());
//        for (int i = 0; i < eventsArray.length(); i++) {
//            JSONObject event = eventsArray.getJSONObject(i);
//            int eventLogType = event.getInt("eventLogType");
//            if (eventLogType == 5) {
//                this.loggedIn = true;
//            }
//        }

        if (loggedOut) {
            loggedIn = true;
            loggedOut = false;
        } else {
            throw new IllegalStateException();
        }
    }

    public void invalidLogin() {
        if (loggedOut) {
            loggedIn = false;
            loggedOut = true;
        } else {
            throw new IllegalStateException();
        }
    }

    public void logout() {
//        StringBuffer eventsLogResponse = getEventsLog();
//        JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());
//        for (int i = 0; i < eventsArray.length(); i++) {
//            JSONObject event = eventsArray.getJSONObject(i);
//            int eventLogType = event.getInt("eventLogType");
//            if (eventLogType == 6) {
//                System.out.println("Valid login at: " + System.currentTimeMillis());
        //        loggedIn = false;
//                loggedOut = true;
//            }
//        }
        if (loggedIn) {
            loggedIn = false;
            loggedOut = true;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
