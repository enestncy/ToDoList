package com.enestuncay.service;

import com.enestuncay.dao.UserDAO;
import com.enestuncay.entity.List;
import com.enestuncay.entity.User;
import com.enestuncay.security.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserDAO userDAO;


    @Autowired
    private MailService mailService;


    @Autowired
    private ListService listService;


    public Long createUser(User user)
    {

        String uuid = UUID.randomUUID().toString();

        user.setKeyreg(uuid);

        if(userDAO.insert(user) > 0)
            mailService.registerMail(user.getEmail(), user.getKeyreg());

        return 1L;
    }


    public void updateUser(User user)
    {
        userDAO.update(user);
    }


    public void deleteUser(User user , HttpServletRequest request){
        ArrayList<List> userLists = listService.getListByUserId(LoginFilter.user.getId());

        for (List list:userLists) {
            listService.deleteList(list , request);
        }

        userDAO.delete(user);
    }

    public User getUserByUsernameAndPass(User user)
    {
        return userDAO.getByUsernameAndPass(user.getUsername(), user.getPass());
    }


    public User getUserByUsername(String username)
    {
        return userDAO.getByUsername(username);
    }

    public boolean getUserByKey(String key)
    {
        User user = userDAO.getByKey(key);

        if(user != null) {
            user.setActive(true);
            userDAO.update(user);
            return true;
        }
        else
            return false;
    }


}
