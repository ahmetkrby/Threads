import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int i = 0; i<1000; i++) {
            inputList.add(i);
        }

        int portionNumber = inputList.size() / 4;

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers= new ArrayList<>();


        Thread thread = new NumberThread(inputList.subList(0, portionNumber), evenNumbers, oddNumbers);
        Thread thread1 = new NumberThread(inputList.subList(portionNumber, portionNumber * 2), evenNumbers, oddNumbers);
        Thread thread2 = new NumberThread(inputList.subList( portionNumber * 2, portionNumber * 3), evenNumbers, oddNumbers);
        Thread thread3 = new NumberThread(inputList.subList(portionNumber * 3, portionNumber * 4), evenNumbers, oddNumbers);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();


        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);


        System.out.println("evenNumbers " + evenNumbers);
        System.out.println("Odd Numbers " + oddNumbers);



    }
}
