package com.something.state;

import com.something.console.CommandLineHandler;
import org.apache.log4j.Logger;

/**
 * Created by alexeyzelenovsky on 8/6/15.
 */
public class ReadHashFunctionsAmountState extends State {

    private final static Logger logger = Logger.getLogger(ReadHashFunctionsAmountState.class);

    private static final Integer DEFAULT_HASH_FUNCTION_AMOUNT = 30;
    private static final Integer MINIMAL_HASH_FUNCTION_AMOUNT = 5;

    private Integer hashFunctionsAmount;

    public ReadHashFunctionsAmountState(CommandLineHandler commandLineHandler) {

        super(commandLineHandler);
    }

    @Override
    protected void printQuestion() {
        logger.debug("Print a question.");
        System.out.print("Please enter the hash functions amount (press Enter to set the default amount 30): ");
    }

    @Override
    protected void enterAnswer() {
        answer = commandLineHandler.scanInput();
        logger.debug("Read an answer: " + answer);
    }

    @Override
    protected void processState() {
        logger.debug("Hash functions amount: " + hashFunctionsAmount);
        commandLineHandler.setHashFunctionsAmount(hashFunctionsAmount);
        commandLineHandler.setState(commandLineHandler.getBuildHashFunctionsState());
    }

    @Override
    protected boolean checkIfAnswerIsValid() {
        return checkIfAnswerIsNumeric() && checkIfAnswerIsLongEnough();
    }

    private boolean checkIfAnswerIsNumeric() {
        if("".equals(answer)) {
            hashFunctionsAmount = DEFAULT_HASH_FUNCTION_AMOUNT;
            return true;
        } else {
            return parseAnswerToInt();
        }
    }

    private boolean parseAnswerToInt() {
        try {
            hashFunctionsAmount = Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("The hash functions amount should be an Integer number. Please try again.");
        }
        return false;
    }

    private boolean checkIfAnswerIsLongEnough() {
        if(hashFunctionsAmount < MINIMAL_HASH_FUNCTION_AMOUNT) {
            System.out.println("The hash functions amount should be al least 5. Please try again.");
            return false;
        }
        return true;
    }
}
