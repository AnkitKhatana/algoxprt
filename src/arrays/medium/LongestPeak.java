package arrays.medium;

public class LongestPeak {

    public enum Slope { INCREASING , DECREASING , SAME };

    public static int longestPeak(int[] array) {
        if(array.length == 0)
            return 0;

        int currentPeakLength=0;
        int longestPeakTillNowLength=0;

        Slope currentSlope = Slope.SAME;
        int previousElement = array[0];

        for(int i=1; i<array.length; i++){
            switch(currentSlope) {
                case INCREASING :
                    if(array[i]>previousElement)
                        currentPeakLength++;
                    else if(array[i]==previousElement){
                        currentPeakLength=0;
                        currentSlope=Slope.SAME;
                    }
                    else{
                        currentPeakLength++;
                        currentSlope=Slope.DECREASING;
                    }
                    break;

                case DECREASING :
                    if(array[i]<previousElement)
                        currentPeakLength++;
                    else if(array[i] == previousElement){
                        if(longestPeakTillNowLength < currentPeakLength)
                            longestPeakTillNowLength=currentPeakLength;
                        currentPeakLength=0;
                        currentSlope=Slope.SAME;
                    }
                    else {
                        if(longestPeakTillNowLength < currentPeakLength)
                            longestPeakTillNowLength=currentPeakLength;
                        currentPeakLength=2;
                        currentSlope=Slope.INCREASING;
                    }
                    break;

                case SAME :
                    if(array[i] > previousElement){
                        currentPeakLength=2;
                        currentSlope=Slope.INCREASING;
                    }
                    break;
            }
            previousElement = array[i];
        }

        if(currentSlope==Slope.DECREASING && longestPeakTillNowLength<currentPeakLength)
            longestPeakTillNowLength=currentPeakLength;

        return longestPeakTillNowLength;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int expected = 6;
        int actual = longestPeak(input);
        System.out.println(actual);
    }

}
