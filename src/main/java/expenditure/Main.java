package expenditure;

import java.util.HashSet;
import java.util.Set;

import expenditure.bo.Expense;
import expenditure.bo.ExpenseReport;
import expenditure.bo.Person;

public class Main {
    public static void main(String[] args) {
        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        Person d = new Person("D");
        
        Expense snacks = new Expense("Snacks", 100);
        Set<Person> snacksParticipants = new HashSet<Person>();
        snacksParticipants.add(a);
        snacksParticipants.add(b);
        snacksParticipants.add(c);
        snacksParticipants.add(d);
        snacks.setParticipants(snacksParticipants);
        snacks.setSpendor(a);
        
        Expense taxi = new Expense("Taxi", 500);
        Set<Person> taxiParticipants = new HashSet<Person>();
        taxiParticipants.add(c);
        taxiParticipants.add(d);
        taxi.setParticipants(taxiParticipants);
        taxi.setSpendor(b);
        
        Expense bus = new Expense("Bus", 300);
        Set<Person> busParticipants = new HashSet<Person>();
        busParticipants.add(a);
        busParticipants.add(b);
        bus.setParticipants(busParticipants);
        bus.setSpendor(d);
        
        ExpenseProcessor processor = new SimpleExpenseProcessor();
        processor.add(snacks);
        processor.add(taxi);
        ExpenseReport report = processor.add(bus);
        report.printReport();
        
//        System.out.println(a.getWalletBalance());
//        System.out.println(b.getWalletBalance());
//        System.out.println(c.getWalletBalance());
//        System.out.println(d.getWalletBalance());
        
        
    }
}
