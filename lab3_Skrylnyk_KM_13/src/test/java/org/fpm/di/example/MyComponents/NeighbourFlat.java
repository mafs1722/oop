package org.fpm.di.example.MyComponents;

import javax.inject.Inject;

public class NeighbourFlat {
    private final DiningRoom diningRoom;
    private final Kitchen kitchen;
    private final BedRoom bedRoom;
    private final BathRoom BathRoom;
    private final CommonCoridor CommonCoridor;

    @Inject
    public NeighbourFlat(DiningRoom diningRoom, Kitchen kitchen, BedRoom bedRoom, BathRoom bathRoom, CommonCoridor commonCoridor) {
        this.diningRoom = diningRoom;
        this.kitchen = kitchen;
        this.bedRoom = bedRoom;
        BathRoom = bathRoom;
        CommonCoridor = commonCoridor;
    }

    public DiningRoom getDiningRoom() {
        return diningRoom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public org.fpm.di.example.MyComponents.BathRoom getBathRoom() {
        return BathRoom;
    }

    public org.fpm.di.example.MyComponents.CommonCoridor getCommonCoridor() {
        return CommonCoridor;
    }
}
