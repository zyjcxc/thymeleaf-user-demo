package com.mqa.demo.thymeleaf.controller;

import com.mqa.demo.thymeleaf.dao.UserDao;
import com.mqa.demo.thymeleaf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mengqa
 * @create 2018-05-04 14:58
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDaoImpl;

    /**
     * 查询所有用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userDaoImpl.list());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userDaoImpl.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 保存或修改用户
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdate(User user) {
        user = userDaoImpl.saveOrUpdate(user);

        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userDaoImpl.delete(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 修改用户的界面
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userDaoImpl.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }





}
