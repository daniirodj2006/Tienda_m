package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private CategoriaService categoriaService;
    
     @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/pruebas/listado";

    }
    
        @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        categoria=categoriaService.getCategoria(categoria);
        var productos = categoria.getProductos();
        model.addAttribute("productos", productos);
        return "/pruebas/listado";
    }
        
              @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/pruebas/listado2";

    }
    
}


