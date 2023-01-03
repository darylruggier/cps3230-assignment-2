package com.uom.cps3230.automaton3;

public class Automaton3Operator {
    private boolean viewingAlerts = false;

    public void viewAlerts(int numberOfAlertsPosted, int visibleAlerts) {
        if ((numberOfAlertsPosted > 5 && visibleAlerts > 5) || (numberOfAlertsPosted <= 5 && (visibleAlerts != numberOfAlertsPosted))) {
            return;
        }
        this.viewingAlerts = true;
    }

    public boolean isViewingAlerts() {
        return this.viewingAlerts;
    }
}
