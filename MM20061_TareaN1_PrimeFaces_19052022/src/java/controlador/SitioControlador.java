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
import modelo.entidades.Sitio;
import modelo.sesion.beans.CategoriaFacade;
import modelo.sesion.beans.SitioFacade;
import util.JSFUtil;

/**
 *
 * @author fenix
 */
@ManagedBean
@RequestScoped
public class SitioControlador implements Serializable {

    private Sitio sitio;
    private Categoria categorias;

    @EJB
    SitioFacade sitioFacade;

    @EJB
    CategoriaFacade categoriaFacade;

    public SitioControlador() {
        sitio = new Sitio();
        categorias = new Categoria();
        sitio.setCategoriaID(categorias);
    }

    public List<Categoria> getListCategorias() {
        return categoriaFacade.findAll();
    }

    public List<Sitio> getListSitios() {
        return sitioFacade.findAll();
    }

    public String guardarSitio() {
        sitioFacade.create(sitio);
        sitio = new Sitio();
        sitio.setCategoriaID(categorias);
        JSFUtil.addGlobalMessage("Registrado Correctamente");
        return "";
    }

    public String modificarSitio() {
        sitioFacade.edit(sitio);
        return "";
    }

    /**
     *
     * @return
     */
    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

}
