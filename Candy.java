//Time Complexity: O(n)
//Space Complexity: O(n)
//take a candies array with same length as that if ratings array
//fill them up with 1 initially as all the children will get minimum 1 candy.
//Iterate over the ratings array from 0 to length
//If the ratings at i index is greater than the rating at i-1 index then candies at i must be updates to candies in the i-1 position plus 1
//Now initialise sum to value at n-1 postion in candies array
//Iterate over the ratings array backwards from length-2 till 0
//Here check if the ratings at i index is > than the rating at i+1 index the  updat candies at i index to the max between the candies at i index and candies at i+1 index+1
//Update and add it to the sum
//Return sum
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1; i<ratings.length; i++)
        {
            if( ratings[i] > ratings[i-1])
            {
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[ratings.length-1];
        for(int i=ratings.length-2; i >=0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum+= candies[i];
        }
        return sum;
    }
}