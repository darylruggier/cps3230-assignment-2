package com.uom.cps3230.automaton4;

public class Automaton4Operator {
    private int postedAlertIconType, visibleAlertIconType, visibleAlerts;
    private boolean viewingAlerts;

    public void viewAlert_correctType() {
        this.visibleAlerts = 1;
        this.postedAlertIconType = 1;
        this.visibleAlertIconType = 1;
        this.viewingAlerts = true;
    }

    public void viewAlert_mismatchingAlertType() {
        this.visibleAlerts = 1;
        this.postedAlertIconType = 2;
        this.visibleAlertIconType = 3;
    }

    public void viewAlert_alertNotFound() {
        this.visibleAlerts = 0;
    }

    public int getPostedAlertIconType() {
        return this.postedAlertIconType;
    }

    public int getVisibleAlertIconType() {
        return this.visibleAlertIconType;
    }

    public boolean isViewingAlerts() {
        return this.viewingAlerts;
    }
}
