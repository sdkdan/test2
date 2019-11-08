package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping(value = "/folder")
    public String listFolder(Model model) {
        List<Folder> list = folderService.folderList();
        model.addAttribute("folderList", list);
        return "folder";
    }

    @RequestMapping(value = "/folder/add", method = RequestMethod.GET)
    public String getAddFolder(Model model) {
        model.addAttribute("folder", new Folder());
        return "add";
    }

    @RequestMapping(value = "/folder/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute Folder folder, Model model) {
        model.addAttribute("folder", folder);
        folderService.addFolder(folder);
        //folderRepo.save(folder);
        return "redirect:/folder";
       // return "redirect:/menu";
    }

    @GetMapping("folder/{id}/delete")
    public String deleteFolder(@PathVariable("id") int id) {
        folderService.deleteFolder(id);
        return "redirect:/folder";
    }

    @GetMapping("/folder/{id}/edit")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Folder folder = folderService.findFolder(id);
        model.addAttribute("folder", folder);
        model.addAttribute("folder", folder);

        return "updateFolder";
    }
    @PostMapping("folder/{id}/update")
    public String updateUser(@PathVariable("id") int id, @Valid Folder folder,
                             BindingResult result, @ModelAttribute String event, Model model) {
        folder.setId(id);
        folderService.updateFolder(folder);
        return "redirect:/folder";
    }


//    @RequestMapping(value = "/category")
//    public String listMenu(Model model) {
//        //List<MenuItem> l = {1,2,3};
//        MenuItem menuItem = new MenuItem();
//        menuItem.setName("action");
//        MenuItem menuItem1 = new MenuItem();
//        MenuItem menuItem2 = new MenuItem();
//        List<MenuItem> l1 = new ArrayList<>();
//        l1.add(0, menuItem1);
//        l1.add(1, menuItem2);
//        menuItem.setChildren(l1);
//        model.addAttribute("maincategories", l1);
//
//        return "category";
//    }
//    @RequestMapping(value = "/category1")
//    public String listMenu1(Model model) {
//        //List<MenuItem> l = {1,2,3};
//        MenuItem menuItem = new MenuItem();
//        menuItem.setName("action");
//        MenuItem menuItem1 = new MenuItem();
//        MenuItem menuItem2 = new MenuItem();
//        List<MenuItem> l1 = new ArrayList<>();
//        l1.add(0, menuItem1);
//        l1.add(1, menuItem2);
//        menuItem.setChildren(l1);
//        model.addAttribute("maincategories", l1);
//
//        return "category1";
//    }

//    @RequestMapping(value = "/miracle")
//    public String miracle() {
//        List<Folder> folderList = folderService.folderList();
//
//        for(Folder cat : folderList) {
//            recursiveTree(cat);
//        }
//
//        return "miracle";
//    }

//    private void recursiveTree(Folder cat) {
//        //System.out.println(cat.getName());
//        if (cat.getClosureList().size() > 0) {
//            for (Closure c : cat.getClosureList()) {
//                recursiveTree(c);
//            }
//        }
//    }


}
