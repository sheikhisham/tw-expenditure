package expenditure;

import java.util.Set;

import expenditure.bo.Expense;
import expenditure.bo.ExpenseReport;
import expenditure.bo.Person;

public class SimpleExpenseProcessor implements ExpenseProcessor {
    private SimpleExpenseReporter reporter = new SimpleExpenseReporter();

    public ExpenseReport add(Expense expense) {
        updateReportParticipants(expense.getParticipants());
        int share = calculatePerShare(expense);
        updateWallets(share, expense.getParticipants());
        updateWallet(expense);
        return generateExpenseReport();
    }

    private void updateReportParticipants(Set<Person> eparticipants) {
        reporter.updateParticipants(eparticipants);
    }

    private ExpenseReport generateExpenseReport() {
        return reporter.generateReport();
    }

    private void updateWallet(Expense expense) {
        Person spendor = expense.getSpendor();
        int wallet = spendor.getWalletBalance();
        wallet = wallet + expense.getAmount();
        spendor.setWalletBalance(wallet);
    }

    private void updateWallets(int share, Set<Person> participants) {
        for (Person p : participants) {
            int wallet = p.getWalletBalance();
            wallet = wallet - share;
            p.setWalletBalance(wallet);
        }
    }

    private int calculatePerShare(Expense expense) {
        return expense.getAmount() / expense.getParticipants().size();
    }
}
