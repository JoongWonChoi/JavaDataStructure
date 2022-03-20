package Stack;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int developTime(int progressTime, int speed){
        int temp = 100-progressTime;
        int result;
        if(temp%speed==0){
            result = temp / speed;
        }
        else{
            result = temp / speed + 1;
        }
        return result;
    }

    public List<Integer> test(List<Integer> dtime) {
        int size = dtime.size();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int n=1;
        for (int i = 0; i < size; i++) {
            if (dtime.get(left) < dtime.get(i+1)) {
                list.add(n);
                n=1;
                left = i;
            }
            else {
                n += 1;
            }
            if (left == size - 1) {
                list.add(1);
            }
        }
       /* int k = 0;
        int i = 1;
        while (k<size) {

            if (dtime.get(left) < dtime.get(i)) {
                list.add(n);
                n=1;
                left = i;
            }
            else {
                n += 1;
            }
            i += 1;
            k+=1;
        }*/
        return list;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        //1. 각 기능마다 완성되는 데 까지 걸리는 시간 구하기
        List<Integer> dtime = new ArrayList();
        int size = progresses.length;
        for(int i=0;i<size;i++){
            dtime.add(developTime(progresses[i], speeds[i]));
        }

        /*System.out.print("dtime : "); //개발 시간 확인 Test
        for (int k : dtime) {
            System.out.println(k);
        }*/

        //2. 조건에 맞게 로직 설계
        List<Integer> result = test(dtime);
        /*System.out.print("result : "); //List 객체 형태로 반환된 result 리스트 Test
        for (int k : result) {
            System.out.println(k);
        }*/
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        /*System.out.print("answer : "); //결과를 위한 answer 리스트에 데이터 옮기기 Test
        for (int k : answer) {
            System.out.println(k);
        }*/
        return answer;
    }
}


public class 기능개발 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {93,30,55};
        int[] b = {1, 30, 5};

       /* int[] a = {95,90,99,99,80,99};
        int[] b = {1, 1,1,1,1,1};*/
        int[] result = s.solution(a, b);
        System.out.print("result  : ");
        for (int k : result) {
            System.out.println(k);
        }





    }
}
