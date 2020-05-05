import java.util.*;

public class recursiveFunctions{

public recursiveFunctions() {
int l= 0;
int k= 0;
int t= 0;
}

public Integer bunnyEars(int n){//n is iteration of bunnies
  int k;
  if(n==0){//if there are no bunnies there are no ears
    return 0;
  }else if(n%2 == 1){//if we are on an odd iteration of bunnies there are two more ears added to the total ears
    k = 2 + bunnyEars(n-1);
  }else{// if we are on an even iteration of bunnies there are three more ears added to the total number of ears
    k = 3 + bunnyEars(n-1);
  }
  return k;
}

public Integer triangle(int r){//r is the level of blocks
  int t;

  if(r==0){//if there are zero levels there are zero blocks in the triangle
    return 0;
  }else{//the amount of blocks on the level of blocks is added to the blocks on previous levels
    t= r + triangle(r-1);
  }
  return t;
}

public Integer tree(int h){
  int l;
  if(h==0){//at the beginning the tree has one branch/leaf
    return 1;
  }else if(h%5 == 0){//if the height of the tree is divisible by five, multiply the previous value by 3
    l=3*tree(h-5);
  }else{// if the height of the tree is not divisible by five
      h= h-h%5;//subtract the remainder when divided by five from the given height
      l= 3*tree(h-5);//multiply the previous term which is five minus the new h value and multiply by 3
  }
  return l;
}

public static void main(String[] args) {



int inputVal = 4;

  //System.out.println(bunnyEars(k));
  //System.out.println(triangle(inputVal));
  System.out.println(l);

  }
}
