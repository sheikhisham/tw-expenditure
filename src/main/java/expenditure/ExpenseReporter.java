package expenditure;

import java.util.Set;

import expenditure.bo.ExpenseReport;
import expenditure.bo.Person;

public interface ExpenseReporter {
    public ExpenseReport generateReport(Set<Person> participants);
}
