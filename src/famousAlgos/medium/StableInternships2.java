package famousAlgos.medium;

import util.Utils;

import java.util.ArrayList;

public class StableInternships2 {

    public int[][] getDeviationFromPrefMatrix(int[][] prefMatrix) {
        int[][] deviationFromPref = new int[prefMatrix.length][prefMatrix.length];
        for(int i=0; i<prefMatrix.length; i++){
            for(int j=0; j< prefMatrix.length; j++){
                deviationFromPref[prefMatrix[i][j]][i] = j;
            }
        }
        return deviationFromPref;
    }

    public int getValidStableMatch(int[][] deviationMatrixOne , int[][] deviationMatrixTwo , int firstValue , int[] availableValues){
        int validStableMatchValue = -1;
        int lowestPairDeviation = Integer.MAX_VALUE;

        for(int i=0; i<deviationMatrixTwo.length; i++){
            if(availableValues[i] == 0) {
                int currentPairDeviation = deviationMatrixOne[i][firstValue] + deviationMatrixTwo[firstValue][i];
                if(currentPairDeviation < lowestPairDeviation || (currentPairDeviation == lowestPairDeviation && deviationMatrixOne[i][firstValue] < deviationMatrixOne[validStableMatchValue][firstValue])){
                    lowestPairDeviation = currentPairDeviation;
                    validStableMatchValue = i;
                }
            }
        }
        return validStableMatchValue;
    }

    public int[][] stableInternships(int[][] interns, int[][] teams) {
        // Write your code here.
        int[][] pairs = new int[interns.length][2];
        int[][] deviationFromInternPref = getDeviationFromPrefMatrix(interns);
        int[][] deviationFromTeamPref = getDeviationFromPrefMatrix(teams);

        int[] teamStatus = new int[teams.length];

        for(int i=0; i<interns.length; i++){
            pairs[i][0] = i;
            pairs[i][1] = getValidStableMatch(deviationFromInternPref,deviationFromTeamPref,i,teamStatus);
            teamStatus[pairs[i][1]] = -1;
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[][] interns = new int[][] {{0, 1}, {1, 0}};
        int[][] teams = new int[][] {{1, 0}, {1, 0}};
        int[][] expected = new int[][] {{0, 0}, {1, 1}};
        int[][] actual = new StableInternships2().stableInternships(interns, teams);
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
