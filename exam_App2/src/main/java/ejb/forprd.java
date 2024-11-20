
package ejb;

import entity.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Category;

/**
 *
 * @author Acer
 */
@Stateless
public class forprd implements forprdLocal {
@PersistenceContext(unitName = "podpu")EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insert(String name, Integer cid, Integer price) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
Category cm = em.find(Category.class, cid);
Collection<Product> nm = cm.getProductCollection();
Product bn= new Product();
bn.setPname(name);
bn.setCid(cm);
bn.setPprize(price);
cm.setProductCollection(nm);
em.merge(cm);
em.persist(bn);
    }

    @Override
    public void upd(Integer id, Integer cid, String name, Integer price) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
Category cm = em.find(Category.class, cid);
Product vb = em.find(Product.class, id);
vb.setPname(name);
vb.setCid(cm);
vb.setPprize(price);
em.merge(vb);
    }

    @Override
    public Collection<Product> dis() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public Collection<Product> findcat(Integer cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Product> catt(Integer cid) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
Category v = em.find(Category.class, cid);
return em.createNamedQuery("Product.findBycatid").setParameter("cid", v).getResultList();
    }
}
