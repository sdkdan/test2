package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Folder;
import com.example.demo.FolderDao;

import java.util.List;

@Service
public class FolderService {

    public FolderService(){

    }

    @Autowired
    private FolderDao folderDao = new FolderDao();

    @Transactional
    public void setPersonDao(FolderDao folderDao){
        this.folderDao = folderDao;
    }

    @Transactional
    public Folder findFolder(int id) {
        return this.folderDao.findById(id);
    }

    @Transactional
    public void addFolder(Folder folder) {
        this.folderDao.add(folder);
    }

    @Transactional
    public void deleteFolder(int id) {
        this.folderDao.delete(id);
    }

    @Transactional
    public void updateFolder(Folder folder) {
        this.folderDao.update(folder);
    }

    @Transactional
    public List<Folder> folderList() {
        return this.folderDao.folderList();
    }

    @Transactional
    public List<Integer> parentfolderList(int id) {
        return this.folderDao.parentList(id);
    }

    @Transactional
    public List<Integer> childfolderList(int id) {
        return this.folderDao.childFolderList(id);
    }


}
