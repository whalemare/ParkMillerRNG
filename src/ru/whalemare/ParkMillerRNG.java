package ru.whalemare;

/**
 * Made with love
 *
 * @author @whalemare on 2016.
 */
public class ParkMillerRNG {

    /* Constant Park-Miller`s*/
    private static final double A = 16807; // Math.pow(7, 5); (Prime root of M, passes statistical tests and produces a full cycle)
    private static final double M = 2147483647; // Math.pow(2, 31) - 1 (A large prime number)

    /* Constant Shardsh`s */
    private static final double Q = 127773; // M / A (To avoid overflow on A * seed)
    private static final double R = 2836; // M % A (To avoid overflow on A * seed)


    private double seed; // salt for generator (initial number)
    private boolean revert = false;

    /**
     * Initial seed from {@link System#currentTimeMillis()}
     */
    public ParkMillerRNG() {
        this.seed = System.currentTimeMillis();
    }

    /**
     * @param seed not 0 value. Use something like {@link System#currentTimeMillis()}
     * @throws IllegalArgumentException if seed == 0
     */
    public ParkMillerRNG(long seed) {
        if (seed != 0) {
            this.seed = seed;
        } else {
            throw new IllegalArgumentException("Initial seed value must not be zero!");
        }
    }

    public double next() {
        seed = (A * seed) % M;
        return seed / M;
    }

    /**
     * Hook implimentation for getting numbers from [-1;1]
     * @return double from -1 to 1
     */
    public double nextHook() {
        double answer = next();
        if (revert) {
            answer *= -1;
        }
        revert = !revert;
        return answer;
    }
}
