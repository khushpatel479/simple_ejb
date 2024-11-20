/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;
import entity.Category;
import entity.Product;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Acer
 */
@Local
public interface bn1Local {
    public void add(String name , Integer cid , Integer prize);
    public void upd(Integer id , String name , Integer cid , Integer prize);
    public void del(Integer id);
    public Collection<Product> dis();
}
