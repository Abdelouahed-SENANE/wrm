package ma.youcode.wrm.utils;

import ma.youcode.wrm.entities.WaitingList;

public abstract class DefaultHandler {


    public static void waitingListDefaults(WaitingList waitingList){

        if (waitingList.getCapacity() == null) {
            waitingList.setCapacity(Integer.parseInt(System.getenv("APP_DEFAULT_CAPACITY")));
        }
        if (waitingList.getAlgorithm() == null) {
            waitingList.setAlgorithm(System.getenv("APP_DEFAULT_ALGO"));
        }

    }

}
