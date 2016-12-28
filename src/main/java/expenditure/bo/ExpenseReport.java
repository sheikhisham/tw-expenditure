package expenditure.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ExpenseReport {
    @Getter
    private List<String> details = new ArrayList<String>();
    
    public void printReport() {
        for(String d : details) {
            System.out.println(d);
        }
    }
}
