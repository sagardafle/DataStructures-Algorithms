/*
The Java runtime system allows a thread to re-acquire a monitor that it already holds because Java monitors are reentrant. 
Reentrant monitors are important because they eliminate the possibility of a single thread deadlocking itself on a monitor that it already holds.
Consider this class:
*/

class Reentrant {
    public synchronized void a() {
	b();
	System.out.println("here I am, in a()");
    }
    public synchronized void b() {
	System.out.println("here I am, in b()");
    }
}

/*
Reentrant contains two synchronized methods: a and b. The first synchronized method, a, calls the other synchronized method, b.
When control enters method a, the current thread acquires the monitor for the Reentrant object. 
Now, a calls b and because b is also synchronized the thread attempts to acquire the same monitor again. 
Because Java supports reentrant monitors, this works. 
The current thread can acquire the Reentrant object's monitor again and both a and b execute to conclusion as is evidenced by the output:

here I am, in b()
here I am, in a()
In systems that don't support reentrant monitors, this sequence of method calls would cause deadlock.
*/