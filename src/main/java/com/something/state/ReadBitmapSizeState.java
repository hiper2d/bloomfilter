package com.something.state;

import com.something.console.CommandLineHandler;
import org.apache.log4j.Logger;

/**
 * Created by alexeyzelenovsky on 8/6/15.
 */
public class ReadBitmapSizeState extends State {

    private final static Logger logger = Logger.getLogger(ReadBitmapSizeState.class);

    private static final Integer DEFAULT_BITMAP_SIZE = 30_000_000;
    private static final Integer MINIMAL_BITMAP_SIZE = 500_000;

    private Integer bitmapSize;

    public ReadBitmapSizeState(CommandLineHandler commandLineHandler) {
        super(commandLineHandler);
    }

    @Override
    protected void printQuestion() {
        logger.debug("Print a question.");
        System.out.print("Please enter the bitmap size (press Enter to set the default size 30 000 000): ");
    }

    @Override
    protected void enterAnswer() {
        answer = commandLineHandler.scanInput();
        logger.debug("Read an answer: " + answer);
    }

    @Override
    protected void processState() {
        logger.debug("Bitmap Size: " + bitmapSize);
        commandLineHandler.setBitmapSize(bitmapSize);
        commandLineHandler.setState(commandLineHandler.getReadHashFunctionsAmountState());
    }

    @Override
    protected boolean checkIfAnswerIsValid() {
        return checkIfAnswerIsNumeric() && checkIfAnswerIsLongEnough();
    }

    private boolean checkIfAnswerIsNumeric() {
        if("".equals(answer)) {
            bitmapSize = DEFAULT_BITMAP_SIZE;
            return true;
        } else {
            return parseAnswerToLong();
        }
    }

    private boolean parseAnswerToLong() {
        try {
            bitmapSize = Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("The bitmap size should be an Integer number. Please try again.");
        }
        return false;
    }

    private boolean checkIfAnswerIsLongEnough() {
        if(bitmapSize < MINIMAL_BITMAP_SIZE) {
            System.out.println("The bitmap size should be al least 500 000. Please try again.");
            return false;
        }
        return true;
    }
}
