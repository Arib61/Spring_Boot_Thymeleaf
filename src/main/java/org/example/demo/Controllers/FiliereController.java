package org.example.demo.Controllers;


import org.example.demo.Entities.Filiere;
import org.example.demo.Service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("filieres", filiereService.findAll());
        model.addAttribute("title", "Liste des Filières");
        return "filieres/list";
    }

    @GetMapping("/new")
    public String formCreate(Model model) {
        model.addAttribute("filiere", new Filiere());
        return "filieres/form";
    }

    @PostMapping
    public String create(@ModelAttribute Filiere filiere) {
        filiereService.save(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("filiere", filiereService.findById(id));
        return "filieres/details";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("filiere", filiereService.findById(id));
        return "filieres/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Filiere filiere) {
        Filiere existing = filiereService.findById(id);
        existing.setCode(filiere.getCode());
        existing.setNom(filiere.getNom());
        filiereService.save(existing);
        return "redirect:/filieres";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        filiereService.delete(id);
        return "redirect:/filieres";
    }
}
