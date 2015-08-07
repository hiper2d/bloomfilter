package com.something.state;

import com.something.console.CommandLineHandler;
import com.something.hash.IntHashGenerator;
import com.something.hash.IntHashGeneratorsPool;
import com.something.hash.SaltGenerator;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class BuildHashFunctionsState extends State {

    private IntHashGenerator hasGenerator;
    private SaltGenerator saltGenerator;

    public BuildHashFunctionsState(CommandLineHandler commandLineHandler) {
        super(commandLineHandler);
    }

    @Override
    protected void processState() {
        commandLineHandler.setIntHashGeneratorsPool(
                new IntHashGeneratorsPool(
                        commandLineHandler.getBitmapSize(),
                        commandLineHandler.getHashFunctionsAmount()
                )
        );
        commandLineHandler.setState(commandLineHandler.getBuildBitMapState());
    }
}
