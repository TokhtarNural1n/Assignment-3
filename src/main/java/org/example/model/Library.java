package org.example.model;

public class Library {

    private Integer id;
    private String name;
    private String address;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Library(Integer id, String name, String address){
        this(name, address);
        setId(id);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}