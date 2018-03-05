package leetcode.dp

//714. Best Time to Buy and Sell Stock with Transaction Fee
//DescriptionHintsSubmissionsDiscussSolution
//DiscussPick One
//Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
//
//You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
//
//Return the maximum profit you can make.
//
//Example 1:
//Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//Buying at prices[0] = 1
//Selling at prices[3] = 8
//Buying at prices[4] = 4
//Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//Note:
//
//0 < prices.length <= 50000.
//0 < prices[i] < 50000.
//0 <= fee < 50000.

object P714 {
  
   def maxProfitx(prices: Array[Int], fee: Int): Int = {
        val n = prices.length
        if(n==0) return 0
        val dp  =  Array.fill[Int](n,n)(0)     
        
        for( i <- 0 to n-1){
            for( j <- 0 to n-i-1){
                if( j == i+j){
                    dp(j)(i+j) = 0
                }else if( j+1 == i+j){  
                    dp(j)(i+j)=  0.max(prices(i+j) - prices(j) -  fee)
                }else{
                    var v = 0.max(prices(i+j) - prices(j) -  fee)

                    for( k<- j to i+j-1){
                        v = v.max(dp(j)(k) + dp(k+1)(i+j))
                    }
                    dp(j)(i+j) = v
                }
            }
        }
        println( dp.map(_.mkString("\t")) .mkString("\n"))
        return dp(0)(n-1)
   }

   
   def maxProfit(prices: Array[Int], fee: Int): Int = {
        var cash = 0
        var hold = -prices(0);
        for (i <- 1 to  prices.length-1)  {
            cash = Math.max(cash, hold + prices(i) - fee);
            hold = Math.max(hold, cash - prices(i));
            println(cash, hold)
        }
        return cash;
   }
        
  
  def main(args: Array[String]) {
    var prices = Array[Int]();
    var fee =0;
     
    prices = Array(1, 3, 2, 8, 4, 9);
    fee = 2
    
    println(maxProfit(prices, fee))
    
    
    prices = Array(2,1,4,4,2,3,2,5,1,2)
    fee = 1
    println(maxProfit(prices, fee))
     
     
    prices = Array(1,3,7,5,10,3)
    fee = 3
    println(maxProfit(prices, fee))
    
  }
}