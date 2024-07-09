package Stock;

import java.util.*;

public class StockPrice {

  // this will be all of the functions for the assignment
  // calculateAveragePrice
  // findMaximumPrice
  // countOccurences
  // computeCumulativeSum

  // create an arraylist of stock prices
  public static void main(String[] args) {
    ArrayList<Float> stockPrices = new ArrayList<Float>();
    // add 10 days of stockPrices as floats
    stockPrices.add(109.10f);
    stockPrices.add(9.9f);
    stockPrices.add(5.5f);
    stockPrices.add(3.2f);
    stockPrices.add(1.5f);
    stockPrices.add(30.0f);
    stockPrices.add(20.0f);
    stockPrices.add(3.66f);
    stockPrices.add(98.9f);
    stockPrices.add(15.0f);
    // Convert the ArrayList to a float array for testing
    float[] pricesArray = new float[stockPrices.size()];
    for (int i = 0; i < stockPrices.size(); i++) {
      pricesArray[i] = stockPrices.get(i);
    }
    // Calling to each function
    float averagePrice = calculateAveragePrice(pricesArray);
    System.out.println("Average Price: " + averagePrice);
    float maxPrice = findMaximumPrice(pricesArray);
    System.out.println("Maximum Price: " + maxPrice);
    int occurrences = countOccurrences(pricesArray, 15.0f);
    System.out.println("Occurrences of 15.0: " + occurrences);
    //15.0 is the Ideal price for this program, it is set to find 15.0
    
    ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPrices);
    System.out.println("Cumulative Sum: " + cumulativeSum);
  }

  // to calculate the average price of the stocks
  public static float calculateAveragePrice(float[] prices) {
    float sum = 0;
    for (float price : prices) {
      sum += price;
    }
    return sum / prices.length;
  }

  // to find the maximum price of the stocks
  public static float findMaximumPrice(float[] prices) {
    float maxPrice = prices[0];
    for (float price : prices) {
      if (price > maxPrice) {
        maxPrice = price;
      }
    }
    return maxPrice;
  }

  // to count the number of occurrences of a specific stock price
  public static int countOccurrences(float[] prices, float targetPrice) {
    int count = 0;
    for (float price : prices) {
      if (price == targetPrice) {
        count++;
      }
    }
    return count;
  }

  // to compute the cumulative sum of the stock prices
  public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
    ArrayList<Float> cumulativeSum = new ArrayList<>();
    float sum = 0;
    for (float price : prices) {
      sum += price;
      cumulativeSum.add(sum);
    }
    return cumulativeSum;
  }

}