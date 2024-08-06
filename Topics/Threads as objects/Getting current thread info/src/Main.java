class Info {

    public static void printCurrentThreadInfo() {
        // get the thread and print its info
        Thread currentThread = Thread.currentThread();

        String name = currentThread.getName();
        int priority = currentThread.getPriority();

        System.out.println("name: " + name);
        System.out.println("priority: " + priority);
    }
}