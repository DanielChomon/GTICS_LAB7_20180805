package com.example.gtics_lab7_20180805.controller;


import com.example.gtics_lab7_20180805.entity.Site;
import com.example.gtics_lab7_20180805.repository.LocationRepository;
import com.example.gtics_lab7_20180805.repository.SiteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/site")
public class SiteController {

    final LocationRepository locationRepository;
    private final SiteRepository siteRepository;

    public SiteController(SiteRepository siteRepository, LocationRepository locationRepository) {
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaSitios(Model model) {
        model.addAttribute("listaSitios", siteRepository.findAll());
        return "sites/list";
    }

    @GetMapping("/new")
    public String nuevoSitioFrm(Model model, @ModelAttribute("product") Site site) {
        model.addAttribute("listaLocaciones", locationRepository.findAll());
        return "site/newFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("product") @Valid Site site, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (site.getSitename().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear producto");
                model.addAttribute("listaLocaciones", locationRepository.findAll());
                return "site/editFrm";
            } else {
                if (site.getId() == 0) {
                    attr.addFlashAttribute("msg", "Sitio creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Sitio actualizado exitosamente");
                }
                siteRepository.save(site);
                return "redirect:/product";
            }

        } else { //hay al menos 1 error
            model.addAttribute("listaLocaciones", locationRepository.findAll());
            return "product/editFrm";
        }
    }

}
