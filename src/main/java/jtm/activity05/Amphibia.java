package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
    protected byte wheels;
    protected byte sails;

    public Amphibia(String id, float consumption, int tankSize) {

        super(id, consumption, tankSize);
        this.wheels = wheels;
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
        if (road.getClass() == Road.class) {
            String status = super.move(road);
            if (!status.startsWith("Cannot")) {
                return getType() + " is driving on " + road + "with" + wheels + " wheels";
            } else {
                return status;
            }

            if (road instanceof WaterRoad) {
                return getType() + " is saling on " + road + "with" + sails + " sails";
            } else {
                return "Cannot sail on " + road;
            }
        }
    }
}