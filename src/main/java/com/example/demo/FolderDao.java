package com.example.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FolderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Folder findById(int id) {
        return sessionFactory.getCurrentSession().get(Folder.class, id);
    }



    public void add(Folder folder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(folder);
    }

    public void update(Folder folder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(folder);
    }

    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Folder folder = (Folder) session.load(Folder.class, id);

        if (folder != null) {
            session.delete(folder);
        }
    }

//    public void move(int id, int parent_id){
//        Session session = this.sessionFactory.getCurrentSession();
//        Folder folder;
//        folder = session.c
//    }"


    @SuppressWarnings("unchecked")
    public List<Folder> folderList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Folder> folderList;
        folderList = (List<Folder>) session.createQuery("From Folder").list();
        return folderList;

    }

    public List<Integer> childFolderList(int id){
        Session session = this.sessionFactory.getCurrentSession();
        List<Integer> childfolderList;
        List<Integer> childfolderList1;
        String queryString = "SELECT child_id FROM Closure WHERE parent_id = :id";
    //    String queryString1 = "SELECT WHERE id IN (:children)";
        Query query = session.createQuery(queryString);
//        Query query1 = session.createQuery(queryString1);
        query.setParameter(id, id);
        childfolderList = query.list();
    //    childfolderList1 = query.list();
        //childfolderList = (List<Integer>) session.createQuery("SELECT child_id FROM Closure_table WHERE parent_id = :id INNER JOIN (SELECT WHERE id IN (:children))").list();
        return childfolderList;
    }

    public List<Integer>  parentList(int id){
        Session session = this.sessionFactory.getCurrentSession();
        List<Integer> parentList;
        String queryString = "SELECT parent_id FROM Closure WHERE child_id = :id ORDER BY depth";
        Query query = session.createQuery(queryString);
        query.setParameter(id, id);
        parentList = query.list();
        return parentList;
    }

}
