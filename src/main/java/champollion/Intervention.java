/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author lucasabitbol
 */
public class Intervention {
    
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private Salle salle;
    private UE ue;
    private Enseignant enseignant;
    private TypeIntervention type;
    
    public Intervention (Salle salle, UE ue, Enseignant enseignant, Date debut, int duree, TypeIntervention type) {
       this.salle = salle; 
       this.ue = ue;
       this.enseignant = enseignant;
       this.debut = debut;
       this.duree = duree;
       this.type = type;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public Salle getSalle() {
        return salle;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }
    
    
    
}
