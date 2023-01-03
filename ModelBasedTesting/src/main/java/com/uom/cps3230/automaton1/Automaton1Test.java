package com.uom.cps3230.automaton1;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import com.uom.cps3230.automaton1.enums.Automaton1Enum;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

public class Automaton1Test implements FsmModel {
    Automaton1Operator sut = new Automaton1Operator(); // System Under Test
    Automaton1Enum stateEnum = Automaton1Enum.LOGGED_OUT;

    boolean loggedOut = true;
    boolean loggedIn = false;

    @Override
    public Automaton1Enum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) sut = new Automaton1Operator();
        loggedOut = true;
        loggedIn = false;
        stateEnum = Automaton1Enum.LOGGED_OUT;
    }

    public boolean invalidLoginGuard() {
        return getState().equals(Automaton1Enum.LOGGED_OUT);
    }
    public @Action void invalidLogin() {
        sut.invalidLogin();

        stateEnum = Automaton1Enum.LOGGED_OUT;

        Assert.assertFalse(sut.isLoggedIn());
    }

    public boolean validLoginGuard() {
        return getState().equals(Automaton1Enum.LOGGED_OUT);
    }
    public @Action void validLogin() throws IOException {
        sut.validLogin();

        stateEnum = Automaton1Enum.LOGGED_IN;
        loggedIn = true;

        Assert.assertTrue(sut.isLoggedIn());
    }

    public boolean logoutGuard() {
        return getState().equals(Automaton1Enum.LOGGED_IN);
    }
    public @Action void logout() {
        sut.logout();

        stateEnum = Automaton1Enum.LOGGED_OUT;
        loggedIn = false;
        loggedOut = true;

        Assert.assertTrue(!sut.isLoggedIn());

    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new Automaton1Test()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
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
