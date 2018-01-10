package ubc.xsun.class3;

import java.util.*;

public class Code_03_StackAndQueueConvert {
    public static class TwoStackQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;


        public TwoStackQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(int data){
            pushStack.push(data);
        }

        public int pop(){
            fillPopStack();
            return popStack.pop();
        }

        public int peek(){
            fillPopStack();
            return popStack.peek();
        }

        private void fillPopStack() {
            if(pushStack.isEmpty() && popStack.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }else if(popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }
    }

    public static class TwoQueueStack {
        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;

        public TwoQueueStack() {
            dataQueue = new LinkedList<>();
            helpQueue = new LinkedList<>();

        }

        public void push(int data){
            dataQueue.add(data);
        }

        public int peek(){
            if(dataQueue.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }
            while (dataQueue.size() != 1){
                helpQueue.add(dataQueue.poll());
            }
            int ret = dataQueue.poll();
            helpQueue.add(ret);
            swap();
            return ret;
        }

        public int pop(){
            if(dataQueue.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }
            while (dataQueue.size() != 1){
                helpQueue.add(dataQueue.poll());
            }
            int ret = dataQueue.poll();
            swap();
            return ret;
        }

        public void swap(){
            Queue<Integer> tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
        }
    }



}
