import java.util.*;

public class recursiveBacktracking{

public recursiveBacktracking() {

}

public boolean groupSum(int start, int[] a, int sum){
//want to change start ecerytime you recursively call
//base case
//return false if we have reached the end of the array
//check where you start based on the array
//recursive call needs to change the starting index
//we either include the value or don't include the value

    //base cases
if(sum == 0){//if the sum is 0 then it is always true
  return true;
}
if(start>a.length-1){//if the index is greater than the length (-1 because index starts at 0)then the sum was never acquired
  return false;
}
if(a[start]==sum){//if the element is the wanted sum return true
  return true;
}
//rest of the problem
// || = or -- works similarly to what we did earlier in the year -- or == 1 or both is true
//can't use if statements or "missing return statement"
//including or excluding the last element, if either are true then it is true
return groupSum(start+1,a,sum-a[start])||groupSum(start+1,a,sum);



}




public static void main(String[] args) {

  recursiveBacktracking r = new recursiveBacktracking();

  int start = 0;
  int[] a = {1,2,3};
  int sum = 7;

  System.out.println(r.groupSum(start,a,sum));

  }

}
