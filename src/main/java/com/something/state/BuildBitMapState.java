package com.something.state;

import com.something.console.CommandLineHandler;
import com.something.dictionary.DictionaryBitmapHandler;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class BuildBitMapState extends State {

    private final static Logger logger = Logger.getLogger(BuildBitMapState.class);

    public BuildBitMapState(CommandLineHandler commandLineHandler) {
        super(commandLineHandler);
    }

    @Override
    protected void processState() throws IOException {
        DictionaryBitmapHandler dictionaryBitmapBuider = new DictionaryBitmapHandler(
                commandLineHandler.getBitmapSize(),
                commandLineHandler.getDictionary(),
                commandLineHandler.getIntHashGeneratorsPool()
        );
        if(logger.isDebugEnabled()) {
            Boolean[] bitmap = dictionaryBitmapBuider.getBitmap();
            logger.debug(new StringBuilder("Bitmap contains ").append(Arrays.asList(bitmap).stream().filter(v -> v == true).count()).append(" positive elements."));
        }
        commandLineHandler.setBitmapHandler(dictionaryBitmapBuider);
        commandLineHandler.setState(commandLineHandler.getCheckWordState());
    }
}
