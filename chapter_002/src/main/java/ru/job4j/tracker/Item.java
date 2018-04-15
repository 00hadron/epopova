package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;
    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
       this.comments = comments;
    }
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String test1, String testDescription, String desc, long created, String comment1) {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreated() {
        return this.created;
    }

    public String[] getComments() {
        return this.comments;
    }


}
