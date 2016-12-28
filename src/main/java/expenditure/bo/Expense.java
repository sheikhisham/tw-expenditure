package expenditure.bo;

import java.util.Set;

import lombok.Data;

@Data
public class Expense {
    
    public Expense(String name, int amountSpent) {
        this.name = name;
        this.amount = amountSpent;
    }

    private int amount;
    private String name;
    private Set<Person> participants;
    private Person spendor;
}
