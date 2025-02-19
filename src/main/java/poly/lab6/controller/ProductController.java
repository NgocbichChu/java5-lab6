package poly.lab6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.lab6.DAO.CategoryDAO;
import poly.lab6.DAO.ProductDAO;
import poly.lab6.entity.Category;
import poly.lab6.entity.Product;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {
    final ProductDAO productDAO;
    final CategoryDAO categoryDAO;

    @RequestMapping("/product/index")
    public String index(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("categories", categories);
        List<Product> items = productDAO.findAll();
        model.addAttribute("items", items);
        return "product/index";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product item = productDAO.findById(id).get();
        model.addAttribute("item", item);
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("categories", categories);
        List<Product> items = productDAO.findAll();
        model.addAttribute("items", items);
        return "product/index";
    }

    @RequestMapping("/product/create")
    public String create(Product item) {
        productDAO.save(item);
        return "redirect:/product/index";
    }

    @RequestMapping("/product/update")
    public String update(Product item) {
        productDAO.save(item);
        return "redirect:/product/edit/" + item.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String create(@PathVariable("id") Integer id) {
        productDAO.deleteById(id);
        return "redirect:/product/index";
    }

    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        List<Product> items = productDAO.findAll(sort); // truy vấn tất cả
        model.addAttribute("items", items);
        return "product/sort";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 3);
        Page<Product> page = productDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }

    @RequestMapping("/product/total-page")
    public String totalPaginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 3);
        Page<Product> page = productDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "product/total-page";
    }
}
