package source.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DesiredMethod {

    // 1) gives the transaction in year 2011 and sort them by value
    public static void getTransactionWithSortedValue(List<Transaction> transactionList) {
        /*
            1) apply stream
            2) apply filter, get year=2011
            3) sort the value based on value
            4) convert into the list
         */

        // full transaction entry
        List<Transaction> newTransactionList = transactionList.stream()
                .filter(p -> p.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        System.out.println(newTransactionList);

       /*  only transaction sorted values gives
            transactionList.stream()
                            .filter(p->p.getYear()==2011)
                            .sorted(Comparator.comparing(Transaction::getValue))
                            .map(f->f.getValue())
                            .forEach(i-> System.out.print(i+" "))
        */
    }

    // 2) What are all the unique cities where the traders work?
    public static void getUniqueCities(List<Transaction> transactionList) {
        // gives the unique city list
        transactionList.stream()
                .map(f -> f.getTrader().getCity())
                .distinct().forEach(i -> System.out.print(i + " "));
    }

    // 3) Find all traders from Cambridge and sort them by name
    public static void getTraderBysorted(List<Transaction> transactionList) {
        /*
            1) first get the trader list
            2) after that find matching city
            3) then store into list
            4) then apply sorting
         */

        List<Trader> newTransactionList = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            Trader trader = transaction.getTrader();
            if (trader.getCity().equals("Cambridge")) {
                newTransactionList.add(trader);
            }
        }

        // after getting all trader in Cambridge sort them by Name
        newTransactionList.sort(Comparator.comparing(Trader::getName));
        System.out.println(newTransactionList);
    }

    // 4) Return a string of all traders’ names sorted alphabetically.
    public static void getTraderNameSorted(List<Transaction> transactionList) {
        /*
            1) apply stream
            2) then apply mapping and get trader obj and want the name only
            3) then sort the name
            4) store the results
         */
        List<String> sortedNameList = transactionList.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .toList();

        System.out.println(sortedNameList);
    }

    // 5) Are any traders based in Milan?
    public static void anyBelongToCity(List<Transaction> transactionList) {
        boolean result = transactionList.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity().equalsIgnoreCase("Milan"));

        System.out.println("Belongs or not : " + result);
    }

    // 6) Print all transactions’ values from the traders living in Cambridge.
    public static void getTransactionValues(List<Transaction> transactionList) {
        List<Integer> transactionValue = transactionList.stream()
                .filter(transaction -> transaction.getTrader()
                                                  .getCity()
                                                  .equalsIgnoreCase("Cambridge"))
                .map(transaction -> transaction.getValue())
                .toList();

        System.out.println(transactionValue);
    }

    // 7) What’s the highest value of all the transactions?
    public static void getHighestTransactionValue(List<Transaction> transactionList) {
        Integer val = transactionList.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, Integer::max);

        System.out.println("Max : "+val);
    }
}
