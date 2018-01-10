package ubc.xsun.class3;

import java.util.Stack;

public class Code_02_GetMinStack {
    public static class MinStack1{
        private Stack<Integer> dataStack;
        private Stack<Integer> stackMin;

        public MinStack1(){
            dataStack = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int obj){
            dataStack.push(obj);
            if(stackMin.isEmpty()){
                stackMin.push(obj);
            }else{
                int tmp = obj <= stackMin.peek()? obj:stackMin.peek();
                stackMin.push(tmp);
            }
        }

        public int pop(){
            if(dataStack.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            stackMin.pop();
            return dataStack.pop();
        }
        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MinStack1 stack2 = new MinStack1();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        stack2.push(6);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
