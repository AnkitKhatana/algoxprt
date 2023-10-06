package famousAlgos.medium;

import util.Utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StableInternships3 {

    public int[][] stableInternships(int[][] interns, int[][] teams) {
        // Write your code here.
        Deque<Integer> freeInterns = new ArrayDeque<>();
        int[] currentPairing = new int[interns.length];
        int[] lastProposed = new int[interns.length];
        Arrays.fill(currentPairing,-1);
        Arrays.fill(lastProposed,-1);
        for(int i=0; i<interns.length; i++)
            freeInterns.addFirst(i);

        int[][] teamsPreference = new int[teams.length][teams.length];
        for(int i=0; i<teams.length; i++){
            for(int j=0; j<teams.length; j++){
                teamsPreference[i][teams[i][j]] = j;
            }
        }

        while(!freeInterns.isEmpty()){
            int currentIntern = freeInterns.removeFirst();
            int lastProposedTeam = ++lastProposed[currentIntern];
            int teamToBeProposed = interns[currentIntern][lastProposedTeam];
            if(currentPairing[teamToBeProposed] == -1) {
                currentPairing[teamToBeProposed] = currentIntern;
            } else if (teamsPreference[teamToBeProposed][currentPairing[teamToBeProposed]] > teamsPreference[teamToBeProposed][currentIntern]) {
                freeInterns.addLast(currentPairing[teamToBeProposed]);
                currentPairing[teamToBeProposed] = currentIntern;
            }
            else {
                freeInterns.addLast(currentIntern);
            }
        }

        int[][] finalPairing = new int[currentPairing.length][2];
        for(int i=0; i<currentPairing.length; i++){
            finalPairing[i][0] = currentPairing[i];
            finalPairing[i][1] = i;
        }
        return finalPairing;
    }

    public static void main(String[] args) {
        int[][] interns = new int[][] {{0, 1}, {0, 1}};
        int[][] teams = new int[][] {{0, 1}, {1, 0}};
        int[][] expected = new int[][] {{0, 0}, {1, 1}};
        int[][] actual = new StableInternships3().stableInternships(interns, teams);
        Utils.assertTrue(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                }
            }
            Utils.assertTrue(containsMatch);
        }
    }
    public static void main1(String[] args) {
        int[][] interns = new int[][] {{0, 1}, {1, 0}};
        int[][] teams = new int[][] {{1, 0}, {1, 0}};
        int[][] expected = new int[][] {{0, 0}, {1, 1}};
        int[][] actual = new StableInternships3().stableInternships(interns, teams);
        Utils.assertTrue(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                }
            }
            Utils.assertTrue(containsMatch);
        }
    }

}
