package com.rsj.aerion.ipinventory.handlers;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;

public abstract class Discovery extends RecursiveAction {

    public abstract void parse() throws IOException;

    @Override
    public abstract void compute();

    public abstract void cleanUp();

    @Scheduled(fixedRate = 120000)
    public final void discover() throws IOException {
        parse();
        compute();
        cleanUp();
    }
}