package ubc.xsun.class3;

public class Code_01_Array_To_Stack_Queue {

    public class ArrayStack {
        private Integer index;
        private Integer[] arr;

        public ArrayStack(int initSize){
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }

            arr = new Integer[initSize];
            index = 0;
        }

        public void push(int obj){
            if(index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[index++] = obj;
        }

        public Integer pop() {
            if(index == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--index];
        }

        public Integer peek(){
            if(index == 0){
                return null;
            }

            return arr[index - 1];
        }
    }


    public class ArrarQueue {
        private int start;
        private int end;
        private int size;

        private Integer[] arr;


        public ArrarQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            start = 0;
            end = 0;
            size = 0;
        }

        public void push(int obj){
            if(size == arr.length - 1){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            end = end == arr.length -1 ? 0:end+1;
            arr[end] = obj;
        }

        public Integer pop() {
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length -1? 0:start+1;
            return arr[tmp];
        }

        public Integer peek(){
            if(size == 0){
                return null;
            }

            return arr[start];
        }
    }
}
