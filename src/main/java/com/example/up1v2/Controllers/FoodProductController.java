package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Food;
import com.example.up1v2.Models.Product;
import com.example.up1v2.Repository.FoodRepository;
import com.example.up1v2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class FoodProductController {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public String productMain(Product product,
                              Model model){
        Iterable<Product> ListProduct = productRepository.findAll();
        model.addAttribute("listProduct", ListProduct);
        return "product";
    }

    @PostMapping("/product")
    public String productAdd(@Valid Product product,
                          BindingResult result){
        if(result.hasErrors())
            return ("product");

        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("product/delete/{id}")
    public String productDelete(@PathVariable long id) {
        productRepository.deleteById(id);
        return("redirect:/product");
    }

    @GetMapping("/food")
    public String foodMain(Food food,
                              Model model){
        Iterable<Food> ListFood = foodRepository.findAll();
        model.addAttribute("listFood", ListFood);
        return "food/index";
    }

    @GetMapping("/food/add")
    public String foodAddView(Food food, Model model){
        Iterable<Product> productsList = productRepository.findAll();
        model.addAttribute("productName", productsList);
        return "food/add";
    }

    @PostMapping("/food/add")
    public String foodAdd(@Valid Food food,
                          BindingResult result,
                          @RequestParam(name = "products") String[] products){
        if(result.hasErrors())
            return ("food/add");

        Iterable<Product> products_list = productRepository.findAll();

        for (Product product: products_list){
            if (product.getFood() == null){
                food.getProducts().add(product);
            }
        }
        foodRepository.save(food);
        return "redirect:/food";
    }

    @GetMapping("food/delete/{id}")
    public String foodDelete(@PathVariable long id) {
        foodRepository.deleteById(id);
        return("redirect:/food");
    }

    @GetMapping("food/edit/{id}")
    public String foodEdit(Model model,
                           @PathVariable long id) {
        Food food = foodRepository.findById(id).orElseThrow();
        model.addAttribute("food", food);
        Iterable<Product> productsList = productRepository.findAll();
        model.addAttribute("productName", productsList);

        return("/food/edit");
    }

    @PostMapping("food/edit/{id}")
    public String foodEdit(@Valid Food food,
                           BindingResult result,
                           @RequestParam(name = "products") String[] products) {
        if (result.hasErrors())
            return("/food/edit");
        Iterable<Product> products_list = productRepository.findAll();

        for (Product product: products_list){
            if (product.getFood() == null){
                food.getProducts().add(product);
            }
        }
        foodRepository.save(food);

        return("redirect:/food");
    }
}
