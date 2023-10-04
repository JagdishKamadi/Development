import source.classes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassInfo {
    public static void main(String[] args) {

            // create the data
            Trader jagdish = new Trader("Jagdish Kamadi","Delhi");
            Trader madhur = new Trader("Madhur Bhoyar","New-York");
            Trader jayant = new Trader("Jayant Awari","Cambridge");
            Trader harshal = new Trader("Harshal Bhoyar","Bangkok");
            Trader amit = new Trader("Amit Chapde","Milan");
            Trader darshan = new Trader("Darshan Folane","Cambridge");
            Trader kunal = new Trader("Kunal Karwatkar","London");
            Trader pratik = new Trader("Pratik Hepat","Dubai");
            Trader tejas = new Trader("Tejas Gawande","Singapore");
            Trader sagar = new Trader("Sagar Bawankule","Istanbul");
            Trader dhiraj = new Trader("Dhiraj Masulkar","London");
            Trader pravin = new Trader("Pravin kamadi","Delhi");

            // create the object of Transaction
            List<Transaction> transactionList = new ArrayList<>();

            // add values
            transactionList.add(new Transaction(jagdish,2011,400));
            transactionList.add(new Transaction(madhur,2011,300));
            transactionList.add(new Transaction(harshal,2012,1200));
            transactionList.add(new Transaction(jayant,2012,500));
            transactionList.add(new Transaction(kunal,2013,1000));
            transactionList.add(new Transaction(pratik,2013,600));
            transactionList.add(new Transaction(darshan,2014,650));
            transactionList.add(new Transaction(sagar,2014,450));
            transactionList.add(new Transaction(amit,2011,650));
            transactionList.add(new Transaction(pravin,2015,560));
            transactionList.add(new Transaction(tejas,2011,350));
            transactionList.add(new Transaction(dhiraj,2016,850));

            // call the method
            System.out.println("Gives the all transaction in year 2011 by sorted value");
            DesiredMethod.getTransactionWithSortedValue(transactionList);
            transactionList.stream().filter(transaction -> transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).toList();
            System.out.println();

            // call the method
            System.out.println("Unique city ");
            DesiredMethod.getUniqueCities(transactionList);
            System.out.println();

            // call the method
            System.out.println("Traders from Cambridge and sort them by name");
            DesiredMethod.getTraderBysorted(transactionList);
            transactionList.stream()
                            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                    .forEach(transaction -> System.out.println(transaction));
            System.out.println();

            // call the method
            System.out.println("Trader name sorted");
            DesiredMethod.getTraderNameSorted(transactionList);
            System.out.println();

            // call the method
            System.out.println("Belongs to Milan or not");
            DesiredMethod.anyBelongToCity(transactionList);
            System.out.println();

            // call the method
            System.out.println("All transaction value in Cambridge");
            DesiredMethod.getTransactionValues(transactionList);
            System.out.println();

            //  call the method
            System.out.println("Highest value transaction ");
            DesiredMethod.getHighestTransactionValue(transactionList);
            System.out.println();


    }


}
