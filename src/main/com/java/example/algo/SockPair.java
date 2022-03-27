package main.com.java.example.algo;

import java.util.Scanner;

public class SockPair {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {
        int numberOfPairs = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int currentSock = arr[i];
            int sockCount = 1;

            for (int j = 1; j < arr.length; j++)
            {
                if(currentSock == arr[j])
                {
                    sockCount += 1;

                    if(sockCount == 2) {
                        numberOfPairs += 1;
                        continue;
                    }

                } 
            }
        }

        return numberOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] ar = new int[n];
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }
        
        int result = sockMerchant(9, new int[] {1, 2, 1, 2, 1, 3, 2, 3, 4});
        System.out.println(result);

        scanner.close();
    }
}
