//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class ClosureService {
//    public ClosureService(){
//
//    }
//
//    @Autowired
//    private ClosureDao closureDao = new ClosureDao();
//
//    @Transactional
//    public void setPersonDao(FolderDao folderDao){
//        this.closureDao = closureDao;
//    }
//
//    @Transactional
//    public Closure findClosure(int id) {
//        return this.closureDao.findById(id);
//    }
//
//    @Transactional
//    public void addClosure(Closure closure) {
//        this.closureDao.add(closure);
//    }
//
//    @Transactional
//    public void deleteClosure(int id) {
//        this.closureDao.delete(id);
//    }
//
//    @Transactional
//    public void updateClosure(Closure closure) {
//        this.closureDao.update(closure);
//    }
//
//    @Transactional
//    public List<Closure> closureList() {
//        return this.closureDao.closureList();
//    }
//}
