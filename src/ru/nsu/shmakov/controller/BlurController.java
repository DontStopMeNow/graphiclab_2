package ru.nsu.shmakov.controller;

import ru.nsu.shmakov.model.Filtrator;

/**
 * Created by kyb1k on 10.03.15.
 */
public class BlurController {
    Filtrator filtrator;

    public BlurController(Filtrator filtrator) {
        this.filtrator = filtrator;
    }

    public void doAction() {
        filtrator.doBlur();
    }
}
