package edu.monash.fit2099;

import java.util.Random;

/**
 * This class contains a static method that will be used by many classes calld nextID()
 */

public class Util {

    /**
     * Static method that is called by most classes to generate random IDs
     *
     * @return random 5 integer ID
     */

    public static int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}
