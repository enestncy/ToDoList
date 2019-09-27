package com.enestuncay.todolist;


import com.enestuncay.entity.Item;
import com.enestuncay.entity.List;
import com.enestuncay.entity.User;
import com.enestuncay.security.LoginFilter;
import com.enestuncay.service.ItemService;
import com.enestuncay.service.ListService;
import com.enestuncay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class LoginController {

    public static String url = "http://localhost:8080/ToDoList_war";


    @Autowired
    private UserService userService;

    @Autowired
    private ListService listService;



    //NEW USER


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {


        return "register";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user , HttpServletRequest request) {


        if(!isValid(user.getEmail())){return new ResponseEntity<String>("ERR_MAIL" , HttpStatus.CREATED);}
        if(!user.getPass().equals(user.getPass2())){return new ResponseEntity<String>( "ERR_PASS" , HttpStatus.CREATED);}
        if(userService.getUserByUsername(user.getUsername()) != null){return new ResponseEntity<String>( "ERR_USERNAME" , HttpStatus.CREATED);}
        if(userService.createUser(user).equals(1L)) {return new ResponseEntity<String>("OK" , HttpStatus.CREATED);}
        return new ResponseEntity<String>("ERROR" , HttpStatus.CREATED);
    }



    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


    @RequestMapping(value = "/reg/{key}", method = RequestMethod.GET)
    public String regOK(@PathVariable("key") String key , Model model) {

        if(userService.getUserByKey(key)) {
            return "redirect:/login?status=ok";
        }

        return "redirect:/login?status=error";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value="status" , required = false) String status , Model model) {

        if(status != null) {
            System.out.println(status);
            if(status.equals("ok")) {
                model.addAttribute("status", "Üyeliğiniz Başarı ile Tamamlandı");
            }
            else if(status.equals("deleted")){
                model.addAttribute("status", "Üyeliğiniz Başarı ile Sonlandırıldı");
            }
            else
                model.addAttribute("status", "Hata! Tekrar Deneyiniz");
        }
        return "login";
    }


    //LOGIN AND CONTROLING USER

    @RequestMapping(value="/controlUser" , method=RequestMethod.POST)
    public ResponseEntity<String> controlUser(@RequestBody User user , HttpServletRequest request)
    {

        User userLogin = userService.getUserByUsernameAndPass(user);
        if(userLogin != null){

            request.getSession().setAttribute("user", userLogin);

            return new ResponseEntity<String>("OK",HttpStatus.OK);
        }
        return new ResponseEntity<String>("ERROR",HttpStatus.OK);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model , HttpServletRequest request) {

        request.getSession().setAttribute("user", null);

        return "redirect:/login";

    }



    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(Model model , HttpServletRequest request) {

        userService.deleteUser(LoginFilter.user , request);

        if(userService.getUserByUsername(LoginFilter.user.getUsername()) == null){
            return "redirect:/login?status=deleted";
        }else{
            return "redirect:/login?status=error";
        }

    }

}
