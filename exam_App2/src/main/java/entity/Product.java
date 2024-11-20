/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPid", query = "SELECT p FROM Product p WHERE p.pid = :pid"),
    @NamedQuery(name = "Product.findByPname", query = "SELECT p FROM Product p WHERE p.pname = :pname"),
    @NamedQuery(name = "Product.findByPprize", query = "SELECT p FROM Product p WHERE p.pprize = :pprize"),
    @NamedQuery(name = "Product.findBycatid",query = "SELECT p FROM Product p WHERE p.cid=:cid"),
    @NamedQuery(name = "Product.tot", query = "SELECT SUM(p.pprize) FROM Product p")
    })
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 110)
    @Column(name = "pname")
    private String pname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pprize")
    private Integer pprize;
    @JoinColumn(name = "cid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category cid;

    public Product() {
    }

    public Product(Integer pid) {
        this.pid = pid;
    }

    public Product(Integer pid, String pname, Integer pprize) {
        this.pid = pid;
        this.pname = pname;
        this.pprize = pprize;
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

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ pid=" + pid + " ]";
    }
    
}
