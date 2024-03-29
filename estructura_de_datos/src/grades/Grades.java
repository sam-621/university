package grades;

public class Grades {
    int[] grades = new int[11];
    int mergeCount = 0;
    int quickCount = 0;

    public Grades() {
        this.fillGrades();
    }

    public void sortByMergeSort(int arr[], int left, int right){
        if(left < right){
            this.mergeCount++;
            int middle = (left + right) / 2;

            sortByMergeSort(arr, left, middle);
            sortByMergeSort(arr, middle+1, right);

            this.merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) {
        this.mergeCount++;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void sortByQuickSort(int A[], int izq, int der) {
        this.quickCount++;

        int pivote=A[izq];
        int i=izq;
        int j=der;
        int aux;

        while(i < j){
            this.quickCount++;
            while(A[i] <= pivote && i < j) i++;
            while(A[j] > pivote) j--;
            if (i < j) {
                aux= A[i];
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];
        A[j]=pivote;

        if(izq < j-1)
            sortByQuickSort(A,izq,j-1);
        if(j+1 < der)
            sortByQuickSort(A,j+1,der);

    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    private void fillGrades() {
        for(int i=0; i<=10; i++) {
            this.grades[i] = this.getRandomNumber();
        }
    }

    private int getRandomNumber() {
        return (int)((Math.random() * 10));
    }
}
