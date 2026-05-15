class Solution {
    public int coinChange(int[] coins, int amount) {
 int[] v=new int[amount+1];
        v[0]=0;
for(int x=1;x<=amount;x++)
{
    v[x]=Integer.MAX_VALUE;
for(int c : coins)
{
if(x-c>=0 && v[x - c] != Integer.MAX_VALUE)
{
    v[x]=Math.min(v[x-c]+1,v[x]);
}
}
}

if(v[amount]==Integer.MAX_VALUE)
return -1;

return v[amount];

}
}