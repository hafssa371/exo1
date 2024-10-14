package ma.projet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "marque")
    private String mrq;
    @Column(name = "reference")
    private String ref;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    @Column(name = "designation")
    private String dsg;

    public Produit() {
    }

    public Produit(String mrq, String ref, Date dateAchat, double prix, String dsg) {
        this.mrq = mrq;
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.dsg = dsg;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMrq() {
        return mrq;
    }

    public void setMrq(String mrq) {
        this.mrq = mrq;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDsg() {
        return dsg;
    }

    public void setDsg(String dsg) {
        this.dsg = dsg;
    }
    
    
}
