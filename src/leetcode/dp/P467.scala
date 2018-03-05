package leetcode.dp

object P467 {
    def findSubstringInWraproundStringX(p: String): Int = {
        val n = p.length
        val dp  =  Array.ofDim[Int](n,n)
        
        val set = collection.mutable.Set[String]()
        for( i <- 0 to n-1){
            for( j <- 0 to n-i-1){
                if( j == i+j){
                    dp(j)(i+j) = 1
                    
                }else{
                    dp(j)(i+j)=  if(dp(j+1)(i+j) ==1 && dp(j)(i+j-1) ==1 && isSubstring( p.substring(j, i+j+1))) 1 else 0
                }
                
                if(1 == dp(j)(i+j)){
                  set += p.substring(j, i+j+1)
                }
            }    
            
        }
        
        return  set.size
    }    
    
    def findSubstringInWraproundString(p: String): Int = {
        val len = 26;
        val counts = new Array[Int](len);
        println(counts.mkString(","))
        var runingLen = 0
        for ( i<- 0 to p.length()-1){
            if (i>0 && isSubstring( p.substring(i-1, i+1))){
              runingLen += 1
            }else{
              runingLen = 1
            }
            
            counts(p(i) - 'a') = Math.max(counts(p(i) - 'a'), runingLen)            
        }
        println(counts.mkString(","))
        return counts.sum
    }
    
    def isSubstring(s : String ): Boolean = {
        var a :Char = s(0);
        var b :Char = s(1);
        
        if( (1 + a.toInt)  == b.toInt || (a =='z' && b=='a')){
          return true
        }
        
        return false
    }
    
    def main(args: Array[String]) {
       var nums = "a"
       println(findSubstringInWraproundString(nums))
       
       nums = "cac"
       println(findSubstringInWraproundString(nums))
       
       nums = "zab"
       println(findSubstringInWraproundString(nums))
       nums = "zabzab"
       println(findSubstringInWraproundString(nums))
       
       nums =  "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
       println(findSubstringInWraproundString(nums))       
       
    }
}