package com.enestuncay.todolist;


import com.enestuncay.entity.Item;
import com.enestuncay.entity.List;
import com.enestuncay.security.LoginFilter;
import com.enestuncay.service.ItemService;
import com.enestuncay.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class HomeController {


    @Autowired
    private ListService listService;

    @Autowired
    private ItemService itemService;


    //INDEX

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {

        return "redirect:/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homes(Model model) {

        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model , HttpServletRequest request) {

        model.addAttribute("user",request.getSession().getAttribute("user"));

        return "index";
    }

    //get all List to index page
    @RequestMapping(value = "/getLists", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<List>> getLists(HttpServletRequest request) {

        return new ResponseEntity<ArrayList<List>>(listService.getListAll(LoginFilter.user.getId()), HttpStatus.CREATED);
    }




    //NEW LIST

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String add(Model model) {

        return "newList";
    }

    @RequestMapping(value = "/newList", method = RequestMethod.POST)
    public ResponseEntity<String> newList(@RequestBody List list , HttpServletRequest request) {


        if(list.getTitle().equals(""))
            return new  ResponseEntity<String> ("ERROR_1" , HttpStatus.OK);

        else if (list.getItems() == null)
            return new  ResponseEntity<String> ("ERROR_2" , HttpStatus.OK);

        else
            {

                List newList = new List();
                newList.setTitle(list.getTitle());

                ArrayList<Item> al = new ArrayList<Item>();

                for(Item item:list.getItems()){
                    if(item.getName() != null){
                        al.add(item);
                    }
                }
                newList.setItems(al);
                listService.createList(newList , request);
            }

            return new  ResponseEntity<String> ("OK" , HttpStatus.CREATED);
    }





    //LIST DETAIL

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") Long id , Model model) {

        model.addAttribute("id", id);
        return "detail";
    }


    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public ResponseEntity<List> getList(@RequestBody String id , HttpServletRequest request) {

        List list = listService.getListById(Long.parseLong(id));

        if(list.getUser_id().equals(LoginFilter.user.getId()))
            return new ResponseEntity<List>(listService.getListById(Long.parseLong(id)),HttpStatus.CREATED);

        List listNull = null;
        return new ResponseEntity<List>(listNull , HttpStatus.CREATED);
    }

    @RequestMapping(value="/updateList" , method=RequestMethod.POST)
    public ResponseEntity<String> updateList(@RequestBody List list , HttpServletRequest request)
    {

        if(list.getTitle().equals(""))
            return new  ResponseEntity<String> ("ERROR_1" , HttpStatus.OK);

        else if (list.getItems() == null)
            return new  ResponseEntity<String> ("ERROR_2" , HttpStatus.OK);

        else {


            List oldList = listService.getListById(list.getId());
            oldList.setItems(itemService.getItemByListId(list.getId()));

            ArrayList<Item> al = new ArrayList<Item>();
            List newList = listService.getListById(list.getId());
            for(Item item:list.getItems()){
                if(item.getName() != null){
                    item.setUser_id(oldList.getUser_id());
                    al.add(item);
                }
            }
            newList.setItems(al);
            newList.setTitle(list.getTitle());

            listService.updateList(oldList , newList ,request);

            return new  ResponseEntity<String> ("OK" , HttpStatus.CREATED);
            }
    }



    @RequestMapping(value="/deleteList" , method=RequestMethod.POST)
    public ResponseEntity<String> deleteList(@RequestBody List list , HttpServletRequest request)
    {


           List oldList = listService.getListById(list.getId());
           oldList.setItems(itemService.getItemByListId(list.getId()));


           listService.deleteList(oldList , request);

           return new  ResponseEntity<String> ("OK" , HttpStatus.CREATED);
    }





}


