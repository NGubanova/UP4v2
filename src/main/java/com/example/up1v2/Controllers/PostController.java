package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Employee;
import com.example.up1v2.Models.Post;
import com.example.up1v2.Models.Role;
import com.example.up1v2.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("")
    public String postMain(Model model){
        Iterable<Post> ListPost = postRepository.findAll();
        model.addAttribute("listPost", ListPost);
        return "post/index";
    }

    @GetMapping("/add")
    public String postAddView(Post post, Model model){
        return "post/add";
    }

    @PostMapping("/add")
    public String postAdd(@Valid Post post,
                              BindingResult result){
        if(result.hasErrors())
            return ("post/add");

        postRepository.save(post);
        return "redirect:/post";
    }

    @GetMapping("/edit/{id}")
    public String postEdit(Model model,
                               @PathVariable long id) {
        Post post = postRepository.findById(id).orElseThrow();
        model.addAttribute("post", post);

        return("/post/edit");
    }

    @PostMapping("/edit/{id}")
    public String postEdit(@Valid Post post,
                           BindingResult result) {
        if (result.hasErrors())
        return("/post/edit");

        postRepository.save(post);

        return("redirect:/post");
    }
    @GetMapping("/delete/{id}")
    public String postDelete(@PathVariable long id) {
        postRepository.deleteById(id);
        return("redirect:/post");
    }
}
