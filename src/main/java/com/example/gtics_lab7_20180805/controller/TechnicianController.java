package com.example.gtics_lab7_20180805.controller;

import com.example.gtics_lab7_20180805.entity.Site;
import com.example.gtics_lab7_20180805.entity.Technician;
import com.example.gtics_lab7_20180805.repository.LocationRepository;
import com.example.gtics_lab7_20180805.repository.SiteRepository;
import com.example.gtics_lab7_20180805.repository.TechnicianRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class TechnicianController {

    private final TechnicianRepository technicianRepository;

    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaTecnicos(Model model) {
        model.addAttribute("listaTecnicos", technicianRepository.findAll());
        return "technician/list";
    }

    @GetMapping("/new")
    public String nuevoSitioFrm(Model model, @ModelAttribute("technician") Technician technician) {
        return "technician/newFrm";
    }

    @PostMapping("/save")
    public String guardarTecnico(RedirectAttributes attr, Model model,
                                  @ModelAttribute("product") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (technician.getFirstName().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear tecnico");
                model.addAttribute("listaTecnicos", technicianRepository.findAll());
                return "technician/editFrm";
            } else {
                if (technician.getId() == 0) {
                    attr.addFlashAttribute("msg", "tecnico creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "tecnico actualizado exitosamente");
                }
                technicianRepository.save(technician);
                return "redirect:/technician";
            }

        } else { //hay al menos 1 error
            model.addAttribute("listaLocaciones", technicianRepository.findAll());
            return "technician/editFrm";
        }
    }

}
