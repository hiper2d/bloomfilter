package com.something.state;

import com.something.console.CommandLineHandler;

/**
 * Created by alexeyzelenovsky on 8/6/15.
 */
public class State {

    private static final String END_INPUT_E = "e";
    private static final String END_INPUT_EXIT = "exit";

    protected CommandLineHandler commandLineHandler;
    protected String answer;

    protected State(CommandLineHandler commandLineHandler) {
        this.commandLineHandler = commandLineHandler;
    }

    public void process() throws Exception {
        printQuestion();
        enterAnswer();
        if(checkIfAnswerIsExitRequest() && checkIfAnswerIsValid()) {
            processState();
        } else {
            processInvalidAnswer();
        }
    }

    protected void printQuestion() {
    }

    protected void enterAnswer() {
    }

    protected void processState() throws Exception {
    }

    protected boolean checkIfAnswerIsValid() {
        return true;
    }

    protected void processInvalidAnswer() {
    }

    private boolean checkIfAnswerIsExitRequest() {
        boolean goodInput = true;
        if(answer != null && END_INPUT_E.equalsIgnoreCase(answer) || END_INPUT_EXIT.equalsIgnoreCase(answer)) {
            commandLineHandler.setState(commandLineHandler.getEndState());
            goodInput = false;
        }
        return goodInput;
    }
}
