package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/folder")
    public String listPerson(Model model) {
        //List<Folder> list = folderService.folderList();
        ArrayList<Folder> list  = new ArrayList<>();
        Folder folder = new Folder();
        list.add(0,folder);
        model.addAttribute("folderList", null);
        return "folder";
    }

    @RequestMapping(value = "/folder/add", method = RequestMethod.GET)
    public String getAddFolder(Model model) {
        List folderList = folderService.folderList();
        model.addAttribute("list", folderList);
        model.addAttribute("folder", new Folder());
        return "add";
    }

    @RequestMapping(value = "/folder/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute Folder folder, Model model) {
        model.addAttribute("folder", folder);
        folderService.addFolder(folder);
        return "redirect:/folder/" + folder.getId();
    }


}
