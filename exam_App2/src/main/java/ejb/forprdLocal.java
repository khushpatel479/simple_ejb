/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Category;
import javax.ejb.Local;
import entity.Product;
import java.util.Collection;
/**
 *
 * @author Acer
 */
@Local
public interface forprdLocal {
    public void insert(String name , Integer cid , Integer price);
    public void upd(Integer id,Integer cid , String name , Integer price);
    public Collection<Product> dis();
    public Collection<Product> findcat(Integer cid);
    public Collection<Product> catt(Integer cid);
}
