public class Stack {

    private int top;
    private int capacity;
    private Customer[] stack;

    Stack(int size) {
        top = -1;
        capacity = size;
        stack = new Customer[capacity];
    }

    // Push an element into the stack
    void stackPush(Customer item) {
        // Check if the stack is full
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        // Insert element at the top
        stack[++top] = item;
    }

    // Pop an element from the stack
    Customer stackPop() {
        // Check if the stack is empty
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        // Remove element
        return stack[top--];
    }

    // Print stack elements
    void stackDisplay() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        // Traverse top to bottom and print
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].toString());
        }
        System.out.println();
    }

    // Print top of stack
    void stackTop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.printf("Top element of the stack: %s%n", stack[top].toString());
        }
    }

}