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

    public static void main(String[] args) {
        System.out.println("trains arrival and departure");
        System.out.println("Arrival : " + Arrays.toString(new int[] { 900, 940, 950, 1100, 1500, 1800 })
                + " Departure : " + Arrays.toString(new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));
        System.out.println("Minimum Paltform Required : " + findPlatform(new int[] { 900, 940, 950, 1100, 1500, 1800 },
                new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));
        System.out.println("Minimum Paltform Required 2 : " + findPlatformBruteForce(
                new int[] { 900, 940, 950, 1100, 1500, 1800 }, new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("trains arrival and departure");
        System.out.println("Arrival : " + Arrays.toString(new int[] { 900, 1100, 1235 }) + " Departure : "
                + Arrays.toString(new int[] { 1000, 1200, 1240 }));
        System.out.println("Minimum Paltform Required : "
                + findPlatform(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));
        System.out.println("Minimum Paltform Required 2 : "
                + findPlatformBruteForce(new int[] { 900, 1100, 1235 }, new int[] { 1000, 1200, 1240 }));

        System.out.println("-------------------------------------------------------------------------------");
    }
}
