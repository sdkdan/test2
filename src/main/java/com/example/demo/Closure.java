package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "closure")
public class Closure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int closure_id;
    @Column(name = "parent_id")
    private int parent_id;
    @Column(name = "child_id")
    private int child_id;
    @Column(name = "depth")
    private int depth;

//    private Folder folder;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    public Folder getFolder() {
//        return this.folder;


//    }

//    public void setFolder(Folder folder) {
//        this.folder = folder;
//    }
    @ManyToOne
    @JoinColumn(name = "id")
    private Folder folder;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getClosure_id() {
        return closure_id;
    }

    public void setClosure_id(int closure_id) {
        this.closure_id = closure_id;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
