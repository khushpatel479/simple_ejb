/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import entity.Category;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.Product;
import ejb.bn1Local;
import java.util.Collection;
import javax.ejb.EJB;

@ManagedBean(name = "pp")
@RequestScoped
public class t3 {
    
    @EJB
    bn1Local vb;
    Integer pid,pprize,cid;
    String pname;
    Collection<Product> cb;
    public String add()
    {
        vb.add(pname, cid, pprize);
        return "ok";
    }
    public String del()
    {
        vb.del(pid);
        return "ok";
    }
    public void dis()
    {
        cb=vb.dis();
    }
    public String upd()
    {
        vb.upd(pid, pname, cid, pprize);
        return "ok";
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
    public Collection<Product> getCb()
    {
        return cb;
    }
}
