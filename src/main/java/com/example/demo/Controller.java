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
//    @Autowired
//    private ClosureService closureService;
//    @Autowired
//    private FolderRepo folderRepo;

    @RequestMapping(value = "/menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping(value = "/folder")
    public String listFolder(Model model) {
        List<Folder> list = folderService.folderList();
//        List<Folder> rootFolderList = folderService.folderList();
//        List<Folder> rootFolderList1;
//        for (Folder folder: rootFolderList
//             ) {
//            if(folder.getClosureList().isEmpty())
//        }
//        for (Folder cat : rootFolderList) {
//            recursiveTree(cat);
//        }
       // Iterable<Folder> list = folderRepo.findAll();
        //ArrayList<Folder> list  = new ArrayList<>();
//        Folder folder = new Folder();
//        list.add(0,folder);
     //  Folder f = folderService.findFolder(1);
       // List<Integer> parentList = folderService.parentfolderList(3);
        //List<Integer> parentList = folderService.childfolderList(1);
        //List<Closure> closureList = folderService.
        model.addAttribute("folderList", list);
        return "folder";
    }

    @RequestMapping(value = "/folder/add", method = RequestMethod.GET)
    public String getAddFolder(Model model) {
        List folderList = folderService.folderList();
       // model.addAttribute("list", folderList);
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
//    @RequestMapping("/deleteFolder")
//    public String deleteFolder(Model model, @RequestParam("id") String id) {
//        if (id != null) {
//            //int id1 = folderRepo.findById(Integer.parseInt(id));
//            this.folderRepo.deleteById(Integer.parseInt(id));
//        }
//        return "redirect:/folder";
//    }

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
//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewUser (@RequestParam String name
//            , @RequestParam int parent_id) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Folder n = new Folder();
//        n.setName(name);
//        n.setParent_id(parent_id);
//        folderRepo.save(n);
//        return "Saved";
//    }
//
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Folder> getAllFolders() {
//        // This returns a JSON or XML with the users
//        return folderRepo.findAll();
//    }

    @RequestMapping(value = "/category")
    public String listMenu(Model model) {
        //List<MenuItem> l = {1,2,3};
        MenuItem menuItem = new MenuItem();
        menuItem.setName("action");
        MenuItem menuItem1 = new MenuItem();
        MenuItem menuItem2 = new MenuItem();
        List<MenuItem> l1 = new ArrayList<>();
        l1.add(0, menuItem1);
        l1.add(1, menuItem2);
        menuItem.setChildren(l1);
        model.addAttribute("maincategories", l1);

        return "category";
    }
    @RequestMapping(value = "/category1")
    public String listMenu1(Model model) {
        //List<MenuItem> l = {1,2,3};
        MenuItem menuItem = new MenuItem();
        menuItem.setName("action");
        MenuItem menuItem1 = new MenuItem();
        MenuItem menuItem2 = new MenuItem();
        List<MenuItem> l1 = new ArrayList<>();
        l1.add(0, menuItem1);
        l1.add(1, menuItem2);
        menuItem.setChildren(l1);
        model.addAttribute("maincategories", l1);

        return "category1";
    }

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
