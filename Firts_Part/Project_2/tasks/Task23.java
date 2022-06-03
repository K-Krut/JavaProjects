package task23;

public class Task23 {
    public static void main(String[] args) {
        int[] a = new int[]{13, -14, 15, 18, -14, 15};
        int[] b = new int[a.length];
        int k = 0, n = 0;
        for(int i = 0; i < a.length; i++){
            k = 1;
            for(int d = 0; d < n; d++){
                if(a[b[d]] == a[i]){
                    k = 0;
                    break;
                }
            }
            if(k == 0)
                continue;
            for(int j = i+1; j < a.length; j++){
                if(a[j] == a[i]){
                    if(k==1)
                        b[n++] = i;
                    b[n++] = j;
                    k =2;
                }
            }
        }
        for(int i = 0; i<n; i = k){
            System.out.print("value: " + a[b[i]] + " indexs: ");
            k = i;
            while((k<n) && (a[b[k]] == a[b[i]])){
                System.out.print(" " + b[k]);
                k++;
            }
            System.out.print("\n");
        }
    }
}
