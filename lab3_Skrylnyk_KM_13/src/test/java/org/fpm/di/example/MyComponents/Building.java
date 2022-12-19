package org.fpm.di.example.MyComponents;

import javax.inject.Inject;

public class Building {
    private final MyFlat myFlat;
    private final NeighbourFlat neighbourFlat;
    private final CommonCoridor commonCoridor;

    @Inject
    public Building(MyFlat myFlat, NeighbourFlat neighbourFlat, CommonCoridor commonCoridor) {
        this.myFlat = myFlat;
        this.neighbourFlat = neighbourFlat;
        this.commonCoridor = commonCoridor;
    }

    public MyFlat getMyFlat() {
        return myFlat;
    }

    public NeighbourFlat getNeighbourFlat() {
        return neighbourFlat;
    }

    public CommonCoridor getCommonCoridor() {
        return commonCoridor;
    }
}
