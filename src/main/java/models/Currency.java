package models;

public class Currency extends Parent{

    public Currency(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Name of currency: %s", this.getName());
    }
}
