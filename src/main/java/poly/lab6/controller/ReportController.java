package poly.lab6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.lab6.DAO.ProductDAO;
import poly.lab6.entity.Report;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReportController {
    final ProductDAO productDAO;

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = productDAO.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
