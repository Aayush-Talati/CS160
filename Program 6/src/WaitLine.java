import java.util.Random;
public class WaitLine {
    private QueueInterface<Customer> line;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;

    public WaitLine() {
        line = new LinkedQueue<>();
        reset();
    }

    public final void reset() {
        line.clear();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    }

    public void simulate(int duration, double arrivalProbability, int maxTransactionTime, long seed) throws EmptyQueueException {
        int clockTime = 0;
        int transactionTime = 0;
        Random random = new Random(seed);
        while (clockTime < duration) {
            if (random.nextDouble() < arrivalProbability) {
                numberOfArrivals++;
                transactionTime = (int) (random.nextDouble() * maxTransactionTime) + 1;
                Customer newCustomer = new Customer(clockTime, transactionTime, numberOfArrivals);
                line.enqueue(newCustomer);
                System.out.println("Customer " + numberOfArrivals + "enters line at time " + clockTime + ", Transaction time is " + transactionTime);
            }
            if (!line.isEmpty()) {
                Customer nextCustomer = line.getFront();
                if (nextCustomer.getTransactionTime() > 0) {
                    transactionTime--;
                } else {
                    nextCustomer = line.dequeue();
                    int waitTime = clockTime - nextCustomer.getArrivalTime();
                    totalTimeWaited += waitTime;
                    numberServed++;
                    System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time " + clockTime + ". Time waited is " + waitTime);
                }
            }
            clockTime++;
        }
    }
    public void displayResults() {
        System.out.println("Number served = " + numberServed);
        System.out.println("Total time waited = " + totalTimeWaited);
        System.out.printf("Average time waited = %.1\n", (double) (totalTimeWaited / numberServed));
        System.out.println("Number left in line " + (numberOfArrivals - numberServed));
    }
}
