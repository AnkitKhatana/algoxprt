package arrays.medium;

public class BestSeat {
    public int bestSeat(int[] seats) {
        // Write your code here.
        int startOfMaxSpace=-1;
        int maxSpaceLength=0;
        int startOfSpace=-1;
        int spaceLength=0;
        for(int i=0; i<seats.length; i++){
            if(seats[i] == 0){
                if(spaceLength==0){
                    startOfSpace=i;
                }
                spaceLength++;
            } else {
                if(spaceLength>0) {
                    if(spaceLength > maxSpaceLength) {
                        maxSpaceLength = spaceLength;
                        startOfMaxSpace = startOfSpace;
                    }
                    startOfSpace=-1;
                    spaceLength=0;
                }
            }
        }

        if(spaceLength > maxSpaceLength){
            maxSpaceLength=spaceLength;
            startOfMaxSpace=startOfSpace;
        }

        return maxSpaceLength>0 ? startOfMaxSpace+(maxSpaceLength/2) : -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 0, 1, 0, 0, 0, 1};
        System.out.println(new BestSeat().bestSeat(input));
    }
}
