package org.example.demo.Controllers;

import org.example.demo.Entities.Eleve;
import org.example.demo.Service.CoursService;
import org.example.demo.Service.EleveService;
import org.example.demo.Service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eleves")
public class EleveController {

    private final EleveService eleveService;
    private final FiliereService filiereService;
    private final CoursService coursService;

    public EleveController(EleveService eleveService, FiliereService filiereService, CoursService coursService) {
        this.eleveService = eleveService;
        this.filiereService = filiereService;
        this.coursService = coursService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("eleves", eleveService.findAll());
        model.addAttribute("title", "Liste des Élèves");
        return "eleves/list";
    }

    @GetMapping("/new")
    public String formCreate(Model model) {
        model.addAttribute("eleve", new Eleve());
        model.addAttribute("filieres", filiereService.findAll());
        model.addAttribute("coursList", coursService.findAll());
        return "eleves/form";
    }

    @PostMapping
    public String create(@RequestParam String nom,
                         @RequestParam String prenom,
                         @RequestParam(required = false) Long filiereId,
                         @RequestParam(required = false, name = "coursIds") List<Long> coursIds) {
        eleveService.createEleve(nom, prenom, filiereId, coursIds);
        return "redirect:/eleves";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("eleve", eleveService.findById(id));
        return "eleves/details";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("eleve", eleveService.findById(id));
        model.addAttribute("filieres", filiereService.findAll());
        model.addAttribute("coursList", coursService.findAll());
        return "eleves/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String nom,
                         @RequestParam String prenom,
                         @RequestParam(required = false) Long filiereId,
                         @RequestParam(required = false, name = "coursIds") List<Long> coursIds) {
        eleveService.updateEleve(id, nom, prenom, filiereId, coursIds);
        return "redirect:/eleves";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        eleveService.deleteEleve(id);
        return "redirect:/eleves";
    }
}
