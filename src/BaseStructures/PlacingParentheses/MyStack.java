package BaseStructures.PlacingParentheses;

public class MyStack<T> {
    private StackNode<T> head;
    private int size;

    public MyStack(){
        this.head = null;
        this.size = 0;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public T top() {
        if (head == null)
            return null;
        return head.value;
    }

    public void push(T value) {
        head = new StackNode<>(value, head);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
class StackNode<T>{
    T value;
    StackNode<T> next;

    public StackNode(T value) {
        this.value = value;
    }

    public StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }
}