package com.uom.cps3230.automaton4;

import com.uom.cps3230.automaton4.enums.Automaton4Enum;
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

public class Automaton4Test implements FsmModel {
    Automaton4Operator sut = new Automaton4Operator(); // System Under Test
    Automaton4Enum stateEnum = Automaton4Enum.NOT_VIEWING_ALERTS;

    int postedAlertIconType = 0;
    int visibleAlertIconType = 0;
    int visibleAlerts = 0;
    boolean viewingAlerts = false;

    // add vars for every state variable of the automaton

    @Override
    public Automaton4Enum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) sut = new Automaton4Operator();
        viewingAlerts = false;
        postedAlertIconType = 0;
        visibleAlertIconType = 0;
        visibleAlerts = 0;
        stateEnum = Automaton4Enum.NOT_VIEWING_ALERTS;
    }

    public boolean viewAlert_correctAlertTypeGuard() { return getState().equals(Automaton4Enum.NOT_VIEWING_ALERTS); }
    public @Action void viewAlert_correctAlertType() {
        sut.viewAlert_correctType();

        stateEnum = Automaton4Enum.VIEWING_ALERTS;

        Assert.assertTrue(sut.isViewingAlerts());
    }

    public boolean viewAlert_mismatchingAlertTypeGuard() { return getState().equals(Automaton4Enum.NOT_VIEWING_ALERTS); }
    public @Action void viewAlert_mismatchingAlertType() {
        sut.viewAlert_mismatchingAlertType();

        stateEnum = Automaton4Enum.BAD_STATE;

        Assert.assertFalse(sut.isViewingAlerts());
    }

    public boolean viewAlert_alertNotFoundGuard() { return getState().equals(Automaton4Enum.NOT_VIEWING_ALERTS); }
    public @Action void viewAlert_alertNotFound() {
        sut.viewAlert_alertNotFound();

        stateEnum = Automaton4Enum.BAD_STATE;

        Assert.assertFalse(sut.isViewingAlerts());
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new Automaton4Test()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
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
