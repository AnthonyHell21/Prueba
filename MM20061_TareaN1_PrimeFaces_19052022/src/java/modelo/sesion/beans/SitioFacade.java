/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Sitio;

/**
 *
 * @author fenix
 */
@Stateless
public class SitioFacade extends AbstractFacade<Sitio> {

    @PersistenceContext(unitName = "MM20061_TareaN1_PrimeFaces_19052022PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SitioFacade() {
        super(Sitio.class);
    }
    
}
