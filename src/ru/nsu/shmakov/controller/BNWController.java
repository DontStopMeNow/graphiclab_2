package ru.nsu.shmakov.controller;

import ru.nsu.shmakov.model.Filtrator;

/**
 * Created by kyb1k on 10.03.15.
 */
public class BNWController {
    Filtrator filtrator;

    public BNWController(Filtrator filtrator) {
        this.filtrator = filtrator;
    }

    public void doAction() {
        filtrator.doBNW();
    }
}
