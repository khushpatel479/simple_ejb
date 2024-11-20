/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Product;
import entity.Category;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class bn1 implements bn1Local {
@PersistenceContext(unitName = "podpu")EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void add(String name, Integer cid, Integer prize) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          Category up = em.find(Category.class, cid);
          Collection<Product> bm = up.getProductCollection();
          Product nv = new Product();
          nv.setPname(name);
          nv.setCid(up);
          nv.setPprize(prize);
          up.setProductCollection(bm);
          em.merge(up);
          em.persist(nv);
    }

    @Override
    public void upd(Integer id, String name, Integer cid, Integer prize) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
Category cm = em.find(Category.class, cid);
Product bn = em.find(Product.class, id);
bn.setPname(name);
bn.setCid(cm);
bn.setPprize(prize);
em.merge(bn);
    }

    @Override
    public void del(Integer id) {

Product vb = em.find(Product.class, id);
em.remove(vb);
    }

    @Override
    public Collection<Product> dis() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
return em.createNamedQuery("Product.findAll").getResultList();
    }
}
