package AZStriverPlaylist.Greedy;

import java.util.*;

/*
 * Problem URL : https://www.geeksforgeeks.org/dsa/minimum-number-platforms-required-railwaybus-station/
 */
public class MinimumNumberOfPlatformRequiredForRailway {
    static class TrainSchedule {
        int arrival;
        int departure;

        public TrainSchedule(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }

    static class TrainProcessing {
        int time;
        boolean isArrive;

        public TrainProcessing(int time, boolean isArrive) {
            this.time = time;
            this.isArrive = isArrive;
        }
    }

    /*
     * TIme Complexity : O(n^2)
     */
    public static int findPlatformBruteForce(int[] Arrival, int[] Departure) {
        int maxPlatform = 0;
        for (int i = 0; i < Arrival.length; i++) {
            int count = 1;
            for (int j = 0; j < Arrival.length; j++) {
                if (i != j && Departure[i] >= Arrival[j] && Departure[j] >= Arrival[i]) {
                    count++;
                }
            }
            maxPlatform = Math.max(count, maxPlatform);
        }
        return maxPlatform;
    }

    /*
     * Time Complexity : O(nlogn)+O(n^2)
     * Space Complexity : O(n)
     */
    public static int findPlatform(int[] Arrival, int[] Departure) {
        List<TrainSchedule> trains = new ArrayList<>();
        for (int i = 0; i < Arrival.length; i++) {
            trains.add(new TrainSchedule(Arrival[i], Departure[i]));
        }
        trains.sort((item1, item2) -> item1.departure - item2.departure);
        List<Integer> platform = new ArrayList<>();

        for (int t = 0; t < trains.size(); t++) {
            int distance = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < platform.size(); i++) {
                if (trains.get(t).arrival > platform.get(i)) {
                    if (trains.get(t).arrival - platform.get(i) < distance) {
                        distance = trains.get(t).arrival - platform.get(i);
                        minIndex = i;
                    }
                }
            }
            if (minIndex == -1) {
                platform.add(trains.get(t).departure);
            } else {
                platform.set(minIndex, trains.get(t).departure);
            }
        }
        return platform.size();
    }

    /*
     * Time Complexity : O(nlog)
     */
    public static int findPlatformBetter(int[] Arrival, int[] Departure) {
        List<TrainProcessing> trains = new ArrayList<>();
        for (int i = 0; i < Arrival.length; i++) {
            trains.add(new TrainProcessing(Arrival[i], true));
            trains.add(new TrainProcessing(Departure[i], false));
        }
        trains.sort((item1, item2) -> {
            if (item1.time - item2.time == 0) {
                if (item1.isArrive && !item2.isArrive)
                    return -1;
                else if (item2.isArrive && !item1.isArrive)
                    return 1;
                else
                    return 0;
            }
            return item1.time - item2.time;
        });
        int maxPlatform = 0;
        int count = 0;
        for (TrainProcessing t : trains) {
            if (t.isArrive)
                count++;
            else
                count--;
            maxPlatform = Math.max(maxPlatform, count);
        }
        return maxPlatform;
    }

    /*
     * Sweep Line Algorithm
     * Time Complexity : O(n)
     */
    public static int findPlatformSweepLineAlgoOptimised(int[] Arrival, int[] Departure) {
        if (Arrival.length == 0)
            return 0;
        int maxDeparture = 0;
        int minArrival = Integer.MAX_VALUE;
        for (int departure : Departure) {
            maxDeparture = Math.max(maxDeparture, departure);
        }

        for (int arrival : Arrival) {
            minArrival = Math.min(minArrival, arrival);
        }
        int[] platformsCount = new int[maxDeparture - minArrival + 2];
        for (int i = 0; i < Arrival.length; i++) {
            platformsCount[Arrival[i] - minArrival]++;
            platformsCount[Departure[i] - minArrival + 1]--;

        }
        int maxPlatform = platformsCount[0];
        for (int i = 1; i < platformsCount.length; i++) {
            platformsCount[i] += platformsCount[i - 1];
            maxPlatform = Math.max(maxPlatform, platformsCount[i]);
        }
        return maxPlatform;
    }

    public static void main(String[] args) {
        System.out.println("trains arrival and departure");

        System.out.println("Arrival : " + Arrays.toString(new int[] { 900, 940, 950, 1100, 1500, 1800 })
                + " Departure : " + Arrays.toString(new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Minimum Paltform Required : " + findPlatform(new int[] { 900, 940, 950, 1100, 1500, 1800 },
                new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));

        System.out.println("Minimum Paltform Required 2 : " + findPlatformBruteForce(
                new int[] { 900, 940, 950, 1100, 1500, 1800 }, new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));

        System.out.println("Minimum Paltform Required : " + findPlatformBetter(
                new int[] { 900, 940, 950, 1100, 1500, 1800 }, new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));

        System.out.println("Minimum Paltform Required Optimised : " + findPlatformSweepLineAlgoOptimised(
                new int[] { 900, 940, 950, 1100, 1500, 1800 }, new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("trains arrival and departure");

        System.out.println("Arrival : " + Arrays.toString(new int[] { 900, 1100, 1235 }) + " Departure : "
                + Arrays.toString(new int[] { 1000, 1200, 1240 }));
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Minimum Paltform Required : "
                + findPlatform(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));

        System.out.println("Minimum Paltform Required 2 : "
                + findPlatformBruteForce(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));

        System.out.println("Minimum Paltform Required : "
                + findPlatformBetter(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));

        System.out.println("Minimum Paltform Required Optimised : "
                + findPlatformSweepLineAlgoOptimised(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));
        System.out.println("-------------------------------------------------------------------------------");
    }
}
