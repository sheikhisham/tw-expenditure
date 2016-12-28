package expenditure;

import java.util.HashSet;
import java.util.Set;

import expenditure.bo.ExpenseReport;
import expenditure.bo.Person;
import lombok.Getter;

public class SimpleExpenseReporter {
    @Getter
    private Set<Person> participants = new HashSet<Person>();
    @Getter
    private ExpenseReport expenseReport = new ExpenseReport();
    
    @Getter
    private ExpenseReport expenseReport2 = new ExpenseReport();
    
    private Set<Person> givers = new HashSet<Person>();
    private Set<Person> takers = new HashSet<Person>();
    
    public ExpenseReport generateReport() {
        ExpenseReport report = new ExpenseReport();
        for(Person p : participants) {
            int wallet = p.getWalletBalance();
            boolean walletNegative = wallet < 0;
            String action = walletNegative ? "has to give" : "gets";
            report.getDetails().add(p.getName() + " " + action + " " + Math.abs(wallet));
            
            if(walletNegative) {
                givers.add(p);
            } else {
                takers.add(p);
            }
        }
        
        for(Person g : givers) {
        }
        
        return report;
    }
    
    public void updateParticipants(Set<Person> eparticipants) {
        for (Person ep : eparticipants) {
            boolean found = false;
            for (Person p : participants) {
                if (ep.getName().equals(p.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                participants.add(ep);
            }
        }
    }
}
