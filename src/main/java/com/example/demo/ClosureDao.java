//package com.example.demo;
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ClosureDao {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public Closure findById(int id) {
//        return sessionFactory.getCurrentSession().get(Closure.class, id);
//    }
//
//
//
//    public void add(Closure closure) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(closure);
//    }
//
//    public void update(Closure closure) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(closure);
//    }
//
//    public void delete(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Closure closure = (Closure) session.load(Closure.class, id);
//
//        if (closure != null) {
//            session.delete(closure);
//        }
//    }
//
////
//
//    @SuppressWarnings("unchecked")
//    public List<Closure> closureList() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Closure> closureList;
//        closureList = (List<Closure>) session.createQuery("From Closure").list();
//        return closureList;
//
//    }
//}
