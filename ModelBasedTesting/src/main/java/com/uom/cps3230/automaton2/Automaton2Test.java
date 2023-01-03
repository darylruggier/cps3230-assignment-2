package com.uom.cps3230.automaton2;

import com.uom.cps3230.automaton2.enums.Automaton2Enum;
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

public class Automaton2Test implements FsmModel {
    Automaton2Operator sut = new Automaton2Operator(); // System Under Test
    Automaton2Enum stateEnum = Automaton2Enum.NOT_VIEWING_ALERTS;

    boolean alertsAreVerified = false;

    @Override
    public Automaton2Enum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) sut = new Automaton2Operator();
        alertsAreVerified = false;
        stateEnum = Automaton2Enum.NOT_VIEWING_ALERTS;
    }

    public boolean viewAlertsWithValidLayoutGuard() {
        return getState().equals(Automaton2Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlerts() {
        sut.viewAlertsWithValidLayout();
        alertsAreVerified = true;

        stateEnum = Automaton2Enum.VIEWING_ALERTS;
        Assert.assertEquals(alertsAreVerified, sut.isLayoutValid());
    }

    public boolean viewAlertsWithInvalidLayoutGuard() {
        return getState().equals(Automaton2Enum.NOT_VIEWING_ALERTS);
    }
    public @Action void viewAlertsWithInvalidLayout() {
        sut.viewAlertsWithInvalidLayout();

        alertsAreVerified = false;

        stateEnum = Automaton2Enum.BAD_STATE;
        Assert.assertEquals(alertsAreVerified, sut.isLayoutValid());
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new Automaton2Test()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
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
