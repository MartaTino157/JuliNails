/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.Depilation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alice
 */
@Stateless
public class DepilationFacade extends AbstractFacade<Depilation> {

    @PersistenceContext(unitName = "JuliNailsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepilationFacade() {
        super(Depilation.class);
    }
    
}
