package data.model.dao.daoimpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int id;
    private LocalDate date;
    private Officiant officiant;
    private Map<Item, Integer> item;

    public Order() {
        this.item = new HashMap<>();
    }

    public Order(LocalDate date, Officiant officiant, Map<Item, Integer> item) {
        this.date = date;
        this.officiant = officiant;
        this.item = item;
    }

    protected Order(int id, LocalDate date, Officiant officiant, Map<Item, Integer> item) {
        this.id = id;
        this.date = date;
        this.officiant = officiant;
        this.item = item;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Officiant getOfficiant() {
        return officiant;
    }

    public void setOfficiant(Officiant officiant) {
        this.officiant = officiant;
    }

    public Map<Item, Integer> getItemsMap() {
        return item;
    }

    protected void setId() {
        //todo ???
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addItem(Item item, int quantity) {
        if (this.item.computeIfPresent(item, (k, v) -> v + quantity) == null) {
            this.item.put(item, quantity);
        }
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void setQuantity(Item item, int quantity) {
        if (this.item.computeIfPresent(item, (k, v) -> quantity) == null) {
            this.item.put(item, quantity);
        }
    }

    public void remove(Item item) {
        this.item.remove(item);
    }
}
