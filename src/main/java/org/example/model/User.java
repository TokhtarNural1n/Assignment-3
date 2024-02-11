package org.example.model;

public class User{
    private Integer id;
    private String name;
    private String groupName;
    private Integer library_id;


    public User( String name, String groupName, Integer library_id) {
        this.name = name;
        this.groupName = groupName;
        this.library_id = library_id;
    }

    public User(Integer id, String name, String groupName, Integer library_id){
        this(name, groupName, library_id);
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

    public String getGroupName() {
        return groupName;
    }

    public Integer getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(Integer library_id) {
        this.library_id = library_id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                ", library_id=" + library_id +
                '}';
    }
}

