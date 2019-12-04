import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        List<Long> longList = Arrays.asList(1000000L, 34234L, 12L, 685L, 9865L, 2379L);

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber: longList){
            threads.add(new FactorialThread(inputNumber));
        }

        for(Thread thread: threads){
            thread.setDaemon(true);
            thread.start();
        }

        for(Thread thread: threads){
            thread.join(2000);
        }

        for(int i = 0; i < longList.size(); i++){
            FactorialThread factorialThread = threads.get(i);
            if(factorialThread.isFinished()){
                System.out.println("Factorial of " + longList.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + longList.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber){
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n){
            BigInteger tempResult = BigInteger.ONE;

            for(long i = n; i > 0; i--){
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished(){
            return isFinished;
        }

        public BigInteger getResult(){
            return result;
        }
    }
}
