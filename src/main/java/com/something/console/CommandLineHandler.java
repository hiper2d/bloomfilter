package com.something.console;

import com.something.dictionary.Dictionary;
import com.something.dictionary.DictionaryBitmapHandler;
import com.something.hash.IntHashGeneratorsPool;
import com.something.state.*;

import java.util.Scanner;

/**
 * Created by alexeyzelenovsky on 8/6/15.
 */
public class CommandLineHandler {

    private State state;
    private State welcomeState;
    private State readBitmapSizeState;
    private State readHashFunctionsAmountState;
    private BuildHashFunctionsState buildHashFunctionsState;
    private BuildBitMapState buildBitMapState;
    private CheckWordState checkWordState;
    private State endState;

    private Integer bitmapSize;
    private Integer hashFunctionsAmount;
    private IntHashGeneratorsPool intHashGeneratorsPool;
    private Dictionary dictionary;
    private DictionaryBitmapHandler bitmapHandler;

    public CommandLineHandler(Dictionary dictionary) {
        this.dictionary = dictionary;
        initStates();
        state = welcomeState;
    }

    private void initStates() {
        welcomeState = new WelcomeState(this);
        readBitmapSizeState = new ReadBitmapSizeState(this);
        readHashFunctionsAmountState = new ReadHashFunctionsAmountState(this);
        buildHashFunctionsState = new BuildHashFunctionsState(this);
        buildBitMapState = new BuildBitMapState(this);
        checkWordState = new CheckWordState(this);
        endState = new EndState(this);
    }

    public String scanInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void startProgram() throws Exception {
        while(!state.equals(endState)) {
            state.process();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getWelcomeState() {
        return welcomeState;
    }

    public void setWelcomeState(State welcomeState) {
        this.welcomeState = welcomeState;
    }

    public State getReadBitmapSizeState() {
        return readBitmapSizeState;
    }

    public void setReadBitmapSizeState(State readBitmapSizeState) {
        this.readBitmapSizeState = readBitmapSizeState;
    }

    public State getReadHashFunctionsAmountState() {
        return readHashFunctionsAmountState;
    }

    public void setReadHashFunctionsAmountState(State readHashFunctionsAmountState) {
        this.readHashFunctionsAmountState = readHashFunctionsAmountState;
    }

    public BuildHashFunctionsState getBuildHashFunctionsState() {
        return buildHashFunctionsState;
    }

    public void setBuildHashFunctionsState(BuildHashFunctionsState buildHashFunctionsState) {
        this.buildHashFunctionsState = buildHashFunctionsState;
    }

    public BuildBitMapState getBuildBitMapState() {
        return buildBitMapState;
    }

    public void setBuildBitMapState(BuildBitMapState buildBitMapState) {
        this.buildBitMapState = buildBitMapState;
    }

    public CheckWordState getCheckWordState() {
        return checkWordState;
    }

    public void setCheckWordState(CheckWordState checkWordState) {
        this.checkWordState = checkWordState;
    }

    public State getEndState() {
        return endState;
    }

    public void setEndState(State endState) {
        this.endState = endState;
    }

    public Integer getBitmapSize() {
        return bitmapSize;
    }

    public void setBitmapSize(Integer bitmapSize) {
        this.bitmapSize = bitmapSize;
    }

    public Integer getHashFunctionsAmount() {
        return hashFunctionsAmount;
    }

    public void setHashFunctionsAmount(Integer hashFunctionsAmount) {
        this.hashFunctionsAmount = hashFunctionsAmount;
    }

    public IntHashGeneratorsPool getIntHashGeneratorsPool() {
        return intHashGeneratorsPool;
    }

    public void setIntHashGeneratorsPool(IntHashGeneratorsPool intHashGeneratorsPool) {
        this.intHashGeneratorsPool = intHashGeneratorsPool;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public DictionaryBitmapHandler getBitmapHandler() {
        return bitmapHandler;
    }

    public void setBitmapHandler(DictionaryBitmapHandler bitmapHandler) {
        this.bitmapHandler = bitmapHandler;
    }
}
