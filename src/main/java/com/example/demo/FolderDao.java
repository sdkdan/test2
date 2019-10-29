package com.example.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @SuppressWarnings("unchecked")
    public List<Folder> folderList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Folder> folderList = (List<Folder>) session.createQuery("From Folder").list();
        return folderList;

    }

}
