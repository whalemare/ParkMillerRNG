package ru.whalemare;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ParkMillerRNG random = new ParkMillerRNG(System.currentTimeMillis());
        final Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < Math.pow(2, 20); i++) {
            double a = Math.rint(10 * random.nextHook()) / 10;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println(map);
    }
}
