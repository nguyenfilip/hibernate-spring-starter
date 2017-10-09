package net.nguyen;

/**
 * Created by nguye on 10/9/2017.
 */
public class DepartmentBudget {
    private String name;
    private Long budget;

    public DepartmentBudget(String name, Long budget) {
        this.name = name;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "DepartmentBudget{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}
