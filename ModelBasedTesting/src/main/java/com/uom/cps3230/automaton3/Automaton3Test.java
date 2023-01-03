package com.uom.cps3230.automaton3;

import com.uom.cps3230.automaton3.enums.Automaton3Enum;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class Automaton3Test implements FsmModel {
    Automaton3Operator sut = new Automaton3Operator(); // System Under Test
    Automaton3Enum stateEnum = Automaton3Enum.NOT_VIEWING_ALERTS;

    int numberOfAlertsPosted = 0;
    int visibleAlerts = 0;

    @Override
    public Automaton3Enum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) sut = new Automaton3Operator();
        numberOfAlertsPosted = 0;
        visibleAlerts = 0;
        stateEnum = Automaton3Enum.NOT_VIEWING_ALERTS;
    }

    public boolean viewAlertsCorrect1Guard() {
        return getState().equals(Automaton3Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlertsCorrect1() {
        numberOfAlertsPosted = 3;
        visibleAlerts = 3;
        sut.viewAlerts(numberOfAlertsPosted, visibleAlerts);

        stateEnum = Automaton3Enum.VIEWING_ALERTS;
        Assert.assertTrue(sut.isViewingAlerts());
    }

    public boolean viewAlertsCorrect2Guard() {
        return getState().equals(Automaton3Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlertsCorrect2() {
        numberOfAlertsPosted = 7;
        visibleAlerts = 5;
        sut.viewAlerts(numberOfAlertsPosted, visibleAlerts);

        stateEnum = Automaton3Enum.VIEWING_ALERTS;
        Assert.assertTrue(sut.isViewingAlerts());
    }

    public boolean viewAlertsBadState1Guard() {
        return getState().equals(Automaton3Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlertsBadState1() {
        numberOfAlertsPosted = 7;
        visibleAlerts = 7;
        sut.viewAlerts(numberOfAlertsPosted, visibleAlerts);

        stateEnum = Automaton3Enum.BAD_STATE;
        Assert.assertFalse(sut.isViewingAlerts());
    }

    public boolean viewAlertsBadState2Guard() {
        return getState().equals(Automaton3Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlertsBadState2() {
        numberOfAlertsPosted = 3;
        visibleAlerts = 2;
        sut.viewAlerts(numberOfAlertsPosted, visibleAlerts);

        stateEnum = Automaton3Enum.BAD_STATE;
        Assert.assertFalse(sut.isViewingAlerts());
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new Automaton3Test()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}
