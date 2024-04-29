package Stack.tests;

import Queue.Queue;
import Stack.Stack;

public class P1 {
    public static void main(String[] args) {
        Stack<Integer> p = new Stack<Integer>();
        int a, b = 1, c;
        p.push(b);
        a = 2 * b - 3;
        p.push(a);
        c = a + 2 * b;
        p.push(c);
        System.out.println(a);
        a = p.peek();
        p.pop();
        c = p.peek();
        p.pop();
        System.out.println(a);
        c = c - 3 * a;
        a = p.peek();
        b = 2 * a - c;
        System.out.println(b);

        System.out.println();

        Queue<Integer> q = new Queue<Integer>();
        int d, e = 1, f;
        q.enqueue(e);
        d = 2 * e - 3;
        q.enqueue(d);
        f = d + 2 * e;
        q.enqueue(f);
        System.out.println(d);
        d = q.peek();
        q.dequeue();
        f = q.peek();
        q.dequeue();
        System.out.println(d);
        f = f - 3 * d;
        d = q.peek();
        e = 2 * d - f;
        System.out.println(e);
    }
}
