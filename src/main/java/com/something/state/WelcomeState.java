package com.something.state;

import com.something.console.CommandLineHandler;

/**
 * Created by alexeyzelenovsky on 8/6/15.
 */
public class WelcomeState extends State {

    public WelcomeState(CommandLineHandler commandLineHandler) {
        super(commandLineHandler);
    }

    @Override
    protected void printQuestion() {
        System.out.println("/------------- Bloom Filter ------------");
        System.out.println("/--- Please follow the instructions ----");
        System.out.println("/-- To exit print 'exit' or just 'e' ---");
        commandLineHandler.setState(commandLineHandler.getReadBitmapSizeState());
    }
}
