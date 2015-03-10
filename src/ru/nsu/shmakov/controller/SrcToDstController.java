package ru.nsu.shmakov.controller;

import ru.nsu.shmakov.model.Filtrator;

/**
 * Created by kyb1k on 10.03.15.
 */
public class SrcToDstController {
    Filtrator filtrator;

    public SrcToDstController(Filtrator filtrator) {
        this.filtrator = filtrator;
    }

    public void doAction() {
        filtrator.srcToDst();
    }
}
