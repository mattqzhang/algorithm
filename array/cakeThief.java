/*
The Cake Thief
You are a renowned thief who has recently switched from stealing precious metals to stealing cakes because of the insane profit margins. You end up hitting the jackpot, breaking into the world's largest privately owned stock of cakes—the vault of the Queen of England.

While Queen Elizabeth has a limited number of types of cake, she has an unlimited supply of each type.

Each type of cake has a weight and a value, stored in objects of a CakeType class:

  public class CakeType {

    final int weight;
    final int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }
}
For example:

  // weighs 7 kilograms and has a value of 160 shillings
new CakeType(7, 160);

// weighs 3 kilograms and has a value of 90 shillings
new CakeType(3, 90);

You brought a duffel bag that can hold limited weight, and you want to make off with the most valuable haul possible.

Write a method maxDuffelBagValue() that takes an array of cake type objects and a weight capacity, and returns the maximum monetary value the duffel bag can hold.

The maxDuffelBagValue method takes an array of CakeType objects and a capacity, and returns the maximum value that can be achieved with that capacity. 
It uses dynamic programming to build up the maximum values for each capacity from 0 to the given capacity.
*/

    public static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        int[] dp = new int[capacity + 1];

        // for each capacity, we try to put each cake type, and dynamically get the max value
        for (int i = 0; i <= capacity; i++) {
            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight <= i) {
                    int maxValue = cakeType.value + dp[i - cakeType.weight];
                    dp[i] = Math.max(dp[i], maxValue);
                }
            }
        }

        return dp[capacity];
    }
