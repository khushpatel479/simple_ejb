/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;
import javax.faces.bean.ManagedBean;
//import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import entity.Product;
import ejb.forprdLocal;
import entity.Category;
import java.util.Collection;
import javax.ejb.EJB;

@ManagedBean(name = "lp")
@RequestScoped
public class prdclass {
    
    @EJB 
    forprdLocal bn;
    
    String pname;
    Integer pid,pprize,cid;
    Collection<Product> er;
    Collection<Product> cname;
    
    public String add()
    {
        bn.insert(pname, cid, pprize);
        return "ok";
    }
    public String upd()
    {
        bn.upd(pid, cid, pname, pprize);
        return "ok";
    }
    public void dis()
    {
        er=bn.dis();
    }
    public void vdis()
    {
        cname = bn.catt(cid);
    }
    
    
    
     public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPprize() {
        return pprize;
    }

    public void setPprize(Integer pprize) {
        this.pprize = pprize;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Collection<Product> getEr()
    {
        return er;
    }
    public Collection<Product> getCname()
    {
        return cname;
    }
}
