mport java.util.*;
class Solution{
 public static void main(String[] a){
  String s=new Scanner(System.in).next();
  int n=s.length(),l=0;
  int[] p=new int[n];
  for(int i=1;i<n;)
   if(s.charAt(i)==s.charAt(l))p[i++]=++l;
   else if(l>0)l=p[l-1];
   else i++;
  int k=n-l;
  System.out.print(n%k==0?k:n);
 }
}
