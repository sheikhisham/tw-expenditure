package expenditure;

import expenditure.bo.Expense;
import expenditure.bo.ExpenseReport;

public interface ExpenseProcessor {
    public ExpenseReport add(Expense expense);
}
