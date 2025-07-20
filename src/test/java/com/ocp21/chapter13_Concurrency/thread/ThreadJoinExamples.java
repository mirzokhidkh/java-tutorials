package com.ocp21.chapter13_Concurrency.thread;

public class ThreadJoinExamples {
    
    public static void main(String[] args) {
        System.out.println("=== Thread join() Examples ===\n");
        
        // Example 1: Basic join() usage
        basicJoinExample();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 2: join() with timeout
        joinWithTimeoutExample();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 3: Multiple threads with join()
        multipleThreadsJoinExample();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 4: join() without waiting (what happens)
        joinWithoutWaitingExample();
    }
    
    // Example 1: Basic join() usage
    public static void basicJoinExample() {
        System.out.println("=== Basic join() Example ===");
        
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started");
            try {
                Thread.sleep(2000); // Simulate work
                System.out.println("Worker thread completed work");
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted");
            }
        });
        
        System.out.println("Main thread: Starting worker thread");
        worker.start();
        
        try {
            System.out.println("Main thread: Waiting for worker to complete...");
            worker.join(); // Wait for worker thread to complete
            System.out.println("Main thread: Worker has finished, continuing...");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting");
        }
        
        System.out.println("Main thread: All done!");
    }
    
    // Example 2: join() with timeout
    public static void joinWithTimeoutExample() {
        System.out.println("=== join() with Timeout Example ===");
        
        Thread longRunningTask = new Thread(() -> {
            System.out.println("Long task started");
            try {
                Thread.sleep(5000); // 5 seconds work
                System.out.println("Long task completed");
            } catch (InterruptedException e) {
                System.out.println("Long task interrupted");
            }
        });
        
        System.out.println("Main thread: Starting long task");
        longRunningTask.start();
        
        try {
            System.out.println("Main thread: Waiting max 3 seconds for completion...");
            boolean finished = longRunningTask.join(3000); // Wait max 3 seconds
            
            if (longRunningTask.isAlive()) {
                System.out.println("Main thread: Task didn't finish in time, still running");
                longRunningTask.interrupt(); // Interrupt the long task
            } else {
                System.out.println("Main thread: Task completed within timeout");
            }
            
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting");
        }
    }
    
    // Example 3: Multiple threads with join()
    public static void multipleThreadsJoinExample() {
        System.out.println("=== Multiple Threads join() Example ===");
        
        Thread[] workers = new Thread[3];
        
        // Create and start multiple worker threads
        for (int i = 0; i < 3; i++) {
            final int workerId = i + 1;
            workers[i] = new Thread(() -> {
                System.out.println("Worker " + workerId + " started");
                try {
                    Thread.sleep(1000 + workerId * 500); // Different work times
                    System.out.println("Worker " + workerId + " completed");
                } catch (InterruptedException e) {
                    System.out.println("Worker " + workerId + " interrupted");
                }
            });
            
            System.out.println("Main thread: Starting worker " + workerId);
            workers[i].start();
        }
        
        // Wait for all workers to complete
        System.out.println("Main thread: Waiting for all workers to complete...");
        for (int i = 0; i < 3; i++) {
            try {
                workers[i].join();
                System.out.println("Main thread: Worker " + (i + 1) + " joined");
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for worker " + (i + 1));
            }
        }
        
        System.out.println("Main thread: All workers completed!");
    }
    
    // Example 4: What happens without join()
    public static void joinWithoutWaitingExample() {
        System.out.println("=== Without join() Example ===");
        
        Thread worker = new Thread(() -> {
            System.out.println("Worker started");
            try {
                Thread.sleep(2000);
                System.out.println("Worker completed");
            } catch (InterruptedException e) {
                System.out.println("Worker interrupted");
            }
        });
        
        System.out.println("Main thread: Starting worker thread");
        worker.start();
        
        // NOT calling join() here - main thread continues immediately
        System.out.println("Main thread: Not waiting, continuing immediately...");
        System.out.println("Main thread: This runs while worker is still working");
        
        // Main thread may finish before worker thread
        System.out.println("Main thread: Finished (worker may still be running)");
    }
    
    // Utility class to demonstrate join() in different scenarios
    public static class TaskRunner {
        
        public static void runParallelTasks() {
            System.out.println("\n=== Parallel Tasks with join() ===");
            
            Thread taskA = new Thread(() -> performTask("A", 1500));
            Thread taskB = new Thread(() -> performTask("B", 1000));
            Thread taskC = new Thread(() -> performTask("C", 2000));
            
            long startTime = System.currentTimeMillis();
            
            // Start all tasks
            taskA.start();
            taskB.start();
            taskC.start();
            
            try {
                // Wait for all to complete
                taskA.join();
                taskB.join();
                taskC.join();
                
                long totalTime = System.currentTimeMillis() - startTime;
                System.out.println("All parallel tasks completed in: " + totalTime + "ms");
                
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting for tasks");
            }
        }
        
        public static void runSequentialTasks() {
            System.out.println("\n=== Sequential Tasks (for comparison) ===");
            
            long startTime = System.currentTimeMillis();
            
            // Run tasks sequentially
            performTask("A", 1500);
            performTask("B", 1000);
            performTask("C", 2000);
            
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("All sequential tasks completed in: " + totalTime + "ms");
        }
        
        private static void performTask(String taskName, int duration) {
            System.out.println("Task " + taskName + " started");
            try {
                Thread.sleep(duration);
                System.out.println("Task " + taskName + " completed");
            } catch (InterruptedException e) {
                System.out.println("Task " + taskName + " interrupted");
            }
        }
    }
    
    // Advanced join() scenarios
    public static class AdvancedJoinExamples {
        
        // Producer-Consumer pattern with join()
        public static void producerConsumerWithJoin() {
            System.out.println("\n=== Producer-Consumer with join() ===");
            
            final StringBuilder sharedData = new StringBuilder();
            
            Thread producer = new Thread(() -> {
                System.out.println("Producer: Starting production");
                for (int i = 1; i <= 5; i++) {
                    sharedData.append("Item").append(i).append(" ");
                    System.out.println("Producer: Added Item" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("Producer: Production completed");
            });
            
            Thread consumer = new Thread(() -> {
                System.out.println("Consumer: Waiting for production to complete");
                try {
                    producer.join(); // Wait for producer to finish
                    System.out.println("Consumer: Processing data: " + sharedData.toString());
                } catch (InterruptedException e) {
                    System.out.println("Consumer: Interrupted while waiting");
                }
            });
            
            // Start both threads
            consumer.start(); // Start consumer first (it will wait)
            producer.start();
            
            try {
                // Wait for both to complete
                producer.join();
                consumer.join();
                System.out.println("Main: Both producer and consumer completed");
            } catch (InterruptedException e) {
                System.out.println("Main: Interrupted");
            }
        }
        
        // Nested join() example
        public static void nestedJoinExample() {
            System.out.println("\n=== Nested join() Example ===");
            
            Thread grandchild = new Thread(() -> {
                System.out.println("Grandchild thread working");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("Grandchild thread completed");
            });
            
            Thread child = new Thread(() -> {
                System.out.println("Child thread starting grandchild");
                grandchild.start();
                try {
                    grandchild.join(); // Child waits for grandchild
                    System.out.println("Child thread: grandchild completed");
                } catch (InterruptedException e) {
                    System.out.println("Child thread interrupted");
                }
            });
            
            Thread parent = new Thread(() -> {
                System.out.println("Parent thread starting child");
                child.start();
                try {
                    child.join(); // Parent waits for child
                    System.out.println("Parent thread: child completed");
                } catch (InterruptedException e) {
                    System.out.println("Parent thread interrupted");
                }
            });
            
            System.out.println("Main thread starting parent");
            parent.start();
            try {
                parent.join(); // Main waits for parent
                System.out.println("Main thread: All nested threads completed");
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}