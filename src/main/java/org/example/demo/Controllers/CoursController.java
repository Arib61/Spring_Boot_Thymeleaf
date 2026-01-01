package org.example.demo.Controllers;


import org.example.demo.Entities.Cours;
import org.example.demo.Service.CoursService;
import org.example.demo.Service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;
    private final FiliereService filiereService;

    public CoursController(CoursService coursService, FiliereService filiereService) {
        this.coursService = coursService;
        this.filiereService = filiereService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("cours", coursService.findAll());
        model.addAttribute("title", "Liste des Cours");
        return "cours/list";
    }

    @GetMapping("/new")
    public String formCreate(Model model) {
        model.addAttribute("coursItem", new Cours());
        model.addAttribute("filieres", filiereService.findAll());
        return "cours/form";
    }

    @PostMapping
    public String create(@RequestParam String code,
                         @RequestParam String intitule,
                         @RequestParam(required = false) Long filiereId) {
        coursService.save(code, intitule, filiereId);
        return "redirect:/cours";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("coursItem", coursService.findById(id));
        model.addAttribute("filieres", filiereService.findAll());
        return "cours/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String code,
                         @RequestParam String intitule,
                         @RequestParam(required = false) Long filiereId) {
        coursService.update(id, code, intitule, filiereId);
        return "redirect:/cours";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        coursService.delete(id);
        return "redirect:/cours";
    }
}
