import java.util.ArrayList;
import java.util.List;

public class NumberThread extends Thread {
    private final List<Integer> inputList;
    private final ArrayList<Integer> evenNumbers;
    private final ArrayList<Integer> oddNumbers;

    public NumberThread(List<Integer> inputList, ArrayList<Integer> evenNumbers, ArrayList<Integer> oddNumbers){
        this.inputList = inputList;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;

    }

    @Override
    public void run() {
        for (Integer i : inputList) {
            if (i % 2 == 0) {
                synchronized (oddNumbers) {
                    oddNumbers.add(i);
                }
            } else {
                synchronized (evenNumbers) {
                    evenNumbers.add(i);
                }
            }
        }
    }
}
