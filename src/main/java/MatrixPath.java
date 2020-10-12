class Solution {

    public int recurency(int[][] A, int right, int down, int result){

        for(int i = 0 ; i < (A.length * A.length) -1 ; i++){

            if(right < A.length -1 && down < A.length -1 && result * A[right+1][down] %10 !=0){
                result*=A[right+1][down];
                right++;
            }
            else if(right < A.length -1 && down < A.length -1 && result * A[right][down+1] %10 !=0){
                result*=A[right][down+1];
                down++;
            }

            else if(right < A.length -1 && down < A.length -1 &&  result * A[right+1][down] < A[right][down+1]){
                result*=A[right+1][down];
                right++;
            }
            else if(right < A.length -1 && down < A.length -1 &&  result * A[right+1][down] < A[right][down+1]){
                result*=A[right][down+1];
                down++;
            }

            else if(right < A.length -1 && down < A.length -1){
                result*=A[right][down+1];
                down++;
            }
            else if(right < A.length -1 && down < A.length -1){
                result*=A[right+1][down];
                right++;
            }
        }

        return result*=A[A.length-1][A.length-1];

    }

    public int solution(int[][] A) {
        if(A.length == 0){
            return 0;
        }

        int right = 0;
        int down = 0;
        int result = A[0][0];

        //if array size is 1x1
        int pathValue =0;
        if(A.length != 1){
            pathValue = recurency(A,right,down,result);
        }else{
            pathValue = A[0][0];
        }

        String pathValueString = Integer.toString(pathValue);

        char [] pathValueCharArr = pathValueString.toCharArray();
        if(pathValueCharArr.length ==1 && pathValueCharArr[0] =='0'){
            return 1;
        }

        if(pathValueCharArr.length ==1 && pathValueCharArr[0] !='0'){
            return 0;
        }

        int res =0;

        for(int i = pathValueCharArr.length -1 ; i > 0 ; i--){
            if(pathValueCharArr[i]=='0'){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}