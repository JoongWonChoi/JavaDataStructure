package DataStructurePractice;

class Stack<T> {
    /*T t = new T(); // --> Type paratmet 'T' cannot be instantiated directly*/
    T list[] = (T[]) new Object[1000]; // 'T' 타입의 객체는 생성할 수 없으므로, Object 클래스를 사용하고 T 타입으로 캐스팅
    int n = 0; //리스트의 길이를 나태날 지표

    //Stack의 기능 - 요소 추가, Last 요소 반환, 모든 요소 보기, Last 요소 반환하지 않고 보기
    public void push(T e) { //스택을 구성하는 'T'타입의 요소 e 파라미터로 입력
        /*가장 마지막으로 쌓여있는 리스트 다음 순서인 n번째에 요소를 추가해주고, n은 1을 더해 다음 인덱스를 가리키도록 설정*/
        list[n] = e;
        n += 1;
    }
    public T pop() {
        if (n == 0) {
            return (T) "list is empty";
        }
        else {
            T temp = list[n-1]; //스택 가장 위에 있는 n번째 요소를 임시 저장 --> return하기 전에 n번째 요소를 없애야하기때문
            list[n-1] = null; // n번째 요소는 null로 만들어 마지막 요소를 꺼낸 것과 같은 원리로 기능하게끔 설계
            n -= 1; // 마지막요소를 하나 반환했기 때문에 길이를 하나 줄여줌
            return temp; //기존의 n번째 요소였던를 임시 저장하였던 T 타입의 temp 반환
        }
    }
    public void show() {
        int k = 0;
        while (k < n) { //k가 n보다 작을 동안 반복. 즉 n보다 커지면 반복 중단. n만큼의 길이인 리스트를 탐색하기 위한 조건
            System.out.println(list[k]);
            k += 1;
        }
    }

    public void peek() {
        System.out.println(list[n-1]);
    }


}



public class StackPractice {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //push test
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.show();
        //pop test
        System.out.println("pop test : " + stack.pop());
        stack.show();
        //peek test
        System.out.print("peek test : ");
        stack.peek();

        stack.push("4");
        stack.push("5");
        stack.push("6");

        stack.pop();
        stack.pop();
        stack.show();



    }
}
