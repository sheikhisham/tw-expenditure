package expenditure.bo;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int walletBalance;
    
    public Person(String name) {
        this.name = name;
    }
}
