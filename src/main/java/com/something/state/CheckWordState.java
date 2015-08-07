package com.something.state;

import com.something.console.CommandLineHandler;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class CheckWordState extends State {

    public CheckWordState(CommandLineHandler commandLineHandler) {
        super(commandLineHandler);
    }

    @Override
    protected void printQuestion() {
        System.out.print("Enter a word to search in a dictionary: ");
    }

    @Override
    protected void enterAnswer() {
        answer = commandLineHandler.scanInput();
    }

    @Override
    protected void processState() throws Exception {
        boolean searchResult = commandLineHandler.getBitmapHandler().searchInBitmap(answer);
        if(searchResult) {
            System.out.printf("Horray! The word '%s' was found! ", answer);
        } else {
            System.out.printf("Sorry, the dictionary does not contain the word '%s'. ", answer);
        }
        System.out.printf("Let's try again.");
        System.out.println();
    }
}
