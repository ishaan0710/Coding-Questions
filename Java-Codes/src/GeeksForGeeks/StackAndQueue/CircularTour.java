package GeeksForGeeks.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/circular-tour/1
 *
 * Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
 * 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump.
 * Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
 * Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
 *
 */

public class CircularTour {

    int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int deficiency[] = new int[n];
        Queue<Integer> currentTour = new LinkedList<>();
        int start = 0;
        int currSum = 0;

        for (int i=0; i<n; i++) {
            deficiency[i] = petrol[i] - distance[i];
        }
        int i = 0;
        while(currentTour.size() != n) {
            //System.out.println("i::" + i + " currSum::" + currSum + " currentTour::" + currentTour);
            currentTour.add(deficiency[i]);
            currSum += deficiency[i];
            i = (i + 1) % n;
            while(currSum < 0) {
                Integer topElement = currentTour.poll();
                start = (start + 1);
                if (start >= n) {
                    return -1;
                }
                if (topElement == null) {
                    currSum = 0;
                    break;
                }
                currSum -= topElement;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int petrol[] =  {7, 6, 7, 5};
        int distance[] = {6, 5, 10, 4};
        System.out.println(new CircularTour().tour(petrol, distance));
    }

}
