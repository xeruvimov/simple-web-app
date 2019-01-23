package data.model.dao.daoimpl;

import java.util.HashSet;
import java.util.Set;

public class Officiant {
    private int id;
    private String firstName;
    private String secondName;
    private Set<Order> orders;

    public Officiant() {
        this.orders = new HashSet<>();
    }

    public Officiant(String firstName, String secondName, Set<Order> orders) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.orders = orders;
    }

    protected Officiant(int id, String firstName, String secondName, Set<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setId() {
        //todo ???
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public boolean remove(Order order) {
        return this.orders.remove(order);
    }

    public boolean contains(Order order) {
        return this.orders.contains(order);
    }
}
