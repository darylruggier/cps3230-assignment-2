package automaton3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class Runner {
	int numberOfAlertsPosted = 0;
	int visibleAlerts = 0;
	
	public StringBuffer getEventLog() throws IOException {
        int responseCode;
        StringBuffer response = new StringBuffer();
        
        
        URL requestURL = new URL("https://api.marketalertum.com/EventsLog/d6353e3c-9340-444d-93ee-371dcfeffb27");
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
			System.out.println("GET request did not work.");
		}
        con.disconnect();
        return response;
    }
	
	public void viewAlertsCorrect1() throws IOException {
		// the idea is to run a function for every possible transition
		// (numberOfAlertsPosted <= 5 && visibleAlerts == numberOfAlertsPosted) -> viewingAlerts (normal state)
		StringBuffer eventsLogResponse = getEventLog();
		JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());

		for (int i = 0; i < eventsArray.length(); i++) {
		    JSONObject event = eventsArray.getJSONObject(i);
		    int eventLogType = event.getInt("eventLogType");
		    if (eventLogType == 0) {
		    	this.numberOfAlertsPosted++;
				
		    }
		}
		this.visibleAlerts = this.numberOfAlertsPosted;
	}
	
	public void viewAlertsCorrect2() throws IOException {
		// (numberOfAlertsPosted >= 5 && visibleAlerts == 5) -> viewingAlerts (normal state)
		StringBuffer eventsLogResponse = getEventLog();
		JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());

		for (int i = 0; i < eventsArray.length(); i++) {
		    JSONObject event = eventsArray.getJSONObject(i);
		    int eventLogType = event.getInt("eventLogType");
		    if (eventLogType == 0) {
		    	this.numberOfAlertsPosted++;
				
		    }
		}
		if (this.numberOfAlertsPosted > 5) {
			this.visibleAlerts = 5;
		}
	}
	
	public void viewAlertsBadState1() throws IOException {
		// (numberOfAlertsPosted >= 5 && visibleAlerts > 5) -> badState
		StringBuffer eventsLogResponse = getEventLog();
		JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());

		for (int i = 0; i < eventsArray.length(); i++) {
		    JSONObject event = eventsArray.getJSONObject(i);
		    int eventLogType = event.getInt("eventLogType");
		    if (eventLogType == 0) {
		    	this.numberOfAlertsPosted++;
				
		    }
		}
		if (this.numberOfAlertsPosted > 5) {
			this.visibleAlerts = this.numberOfAlertsPosted;
		}
	}
	
	public void viewAlertsBadState2() throws IOException {
		// e.g. in this function numberOfAlerts = 3 and visibleAlerts = 2
		// (numberOfAlertsPosed = 3 && visibleAlerts = 2) -> badState
		StringBuffer eventsLogResponse = getEventLog();
		JSONArray eventsArray = new JSONArray(eventsLogResponse.toString());

		for (int i = 0; i < eventsArray.length(); i++) {
		    JSONObject event = eventsArray.getJSONObject(i);
		    int eventLogType = event.getInt("eventLogType");
		    if (eventLogType == 0) {
		    	this.numberOfAlertsPosted++;
		    }
		}
		this.visibleAlerts = this.numberOfAlertsPosted - 1;
	}
	
	public void run() throws IOException {
		final Random rand = new Random();
		final int randomNumber = rand.nextInt(4);
		
		if (randomNumber == 4) {
			this.viewAlertsCorrect1();
		} else if (randomNumber == 3) {
			this.viewAlertsCorrect2();
		} else if (randomNumber == 2) {
			this.viewAlertsBadState1();
		} else if (randomNumber == 1) {
			this.viewAlertsBadState2();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Runner runner = new Runner();
		runner.run();
	}

}
