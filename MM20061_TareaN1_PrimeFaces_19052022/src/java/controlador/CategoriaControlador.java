/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.entidades.Categoria;
import modelo.sesion.beans.CategoriaFacade;
import util.JSFUtil;

/**
 *
 * @author fenix
 */
@ManagedBean
@RequestScoped
public class CategoriaControlador implements Serializable {

    @EJB
    CategoriaFacade categoriaFacade;

    private Categoria categorias;

    public CategoriaControlador() {
        categorias = new Categoria();
    }

    public String guardarCategoria() {
        Categoria tmpCategoria = categoriaFacade.find(categorias.getCategoriaId());
        if (tmpCategoria != null) {
            JSFUtil.addGlobalErrorMessage("Categoria Repetida");
        } else {
            categoriaFacade.create(getCategorias());
            categorias = new Categoria();
            JSFUtil.addGlobalMessage("Registrado Con Exito");
        }
        return "";
    }

    public List<Categoria> getCategoriaList() {
        return categoriaFacade.findAll();
    }

    /**
     *
     * @return
     */
    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

}
