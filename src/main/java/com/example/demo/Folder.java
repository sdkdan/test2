package com.example.demo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "folder", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //@OneToMany(mappedBy = "folder")
    private List<Closure> closureList;
//    private List<Folder> closureList;


    //    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Folder parent;
//
//    @OneToMany(mappedBy = "child_id", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private List<Folder> children = new ArrayList<Folder>();


//    @Column(name = "parent_id")
//    private int parent_id;
//    @Column(name = "child_id")
//    private int child_id;
//    @Column(name = "depth")
//    private int depth;

//    private ArrayList<Folder> folders = new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Closure> getClosureList() {
        return closureList;
    }

    public void setClosureList(List<Closure> closureList) {
        this.closureList = closureList;
    }
//    public List<Folder> getClosureList() {
//        return closureList;
//    }
//
//    public void setClosureList(List<Folder> closureList) {
//        this.closureList = closureList;
//    }

//    public int getParent_id() {
//        return parent_id;
//    }
//
//    public void setParent_id(int parent_id) {
//        this.parent_id = parent_id;
//    }
//
//    public int getChild_id() {
//        return child_id;
//    }
//
//    public void setChild_id(int child_id) {
//        this.child_id = child_id;
//    }
//
//    public int getDepth() {
//        return depth;
//    }
//
//    public void setDepth(int depth) {
//        this.depth = depth;
//    }

//    public ArrayList<Folder> getFolders() {
//        return folders;
//    }
//
//    public void setFolders(ArrayList<Folder> folders) {
//        this.folders = folders;
//    }

//    public void makeTree(Iterable<Folder> f){
//        ArrayList<Folder> folderArrayList = new ArrayList<>();
//        Collection<Folder> folderArrayList1 = StreamSupport.stream(f.spliterator(), false)
//                .collect(Collectors.toList());
//
//        for (int i=0; i < folderArrayList1.size(); i++) {
//            for (Folder folder: folderArrayList1
//                 ) {
//                if (folder.parent_id == i) {
//                    folderArrayList.add(((List<Folder>) folderArrayList1).get(i));
//                }
//            }
//        }
//    }

//    public Folder getParent() {
//        return parent;
//    }
//
//    public void setParent(Folder parent) {
//        this.parent = parent;
//    }

//    public List<Folder> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Folder> children) {
//        this.children = children;
//    }

//    public void recursiveTree(Folder cat) {
//        System.out.println(cat.getName());
//        if (cat.getChildren().size() > 0) {
//            for (Folder c : cat.getChildren()) {
//                recursiveTree(c);
//            }
//        }
//    }

//        public ArrayList<Folder> getChildren() {
//        return children;
//    }
//
//    public void setChildren(ArrayList<Folder> children) {
//        this.children = children;
//    }
}
