// class Solution {
//     public int fib(int n) {
//         if(n==0 || n==1)
//         {
//             return n;
//         }
//         else
//         {
//             return fib(n-1)+fib(n-2);
//         }
//     }
// }

class Solution {
    public int fib(int n) {
        int p1=0;
        int p2=1;
        int next=0;
         if(n==0) return 0;
        if(n==1) return 1;
        for(int i=1;i<=(n-1);i++){
            next =p1+p2;
            p1=p2;
            p2=next;

        }
        return next;
    
    }
}