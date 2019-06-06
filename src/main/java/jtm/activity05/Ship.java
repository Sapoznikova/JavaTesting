package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
    protected byte sails;

    public Ship(String id, float consumption, int tankSize) {

        super(id, 0, 0);
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
// TODO Auto-generated method stub
        if (road instanceof WaterRoad) {
            return getType() + " is saling on " + road + "with" + sails + " sails";
        } else {
            return "Cannot sail on " + road;

        }
    }
}