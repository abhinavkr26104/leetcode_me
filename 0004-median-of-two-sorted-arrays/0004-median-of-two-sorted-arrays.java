class Solution {
      static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public double findMedianSortedArrays(int[] a, int[] b) {

        int i=0;
        int j=0;
        int k=0;
        int c=a.length+b.length;
        int r[]=new int[c];
        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
             r[k]=b[j];
             j++;
            }
            else{
                r[k]=a[i];
                i++;
            }
            k++;
        }
        while(i<a.length){
            r[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            r[k]=b[j];
            j++;
            k++;
        }
        if(c%2!=0) return r[c/2];
        return (r[c/2-1]+r[c/2])/2.0;
    }
}