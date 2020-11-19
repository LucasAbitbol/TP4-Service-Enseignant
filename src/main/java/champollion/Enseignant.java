package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Enseignant extends Personne {

    private ArrayList<ServicePrevu> servicePrev = new ArrayList<>();
    private LinkedList<Intervention> interventions = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public int heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu service : servicePrev) {
            equivalentTD += 1.5 * service.getVolumeCM();
            equivalentTD += service.getVolumeTD();
            equivalentTD += 0.75 * service.getVolumeTP();
        }
        return Math.round(equivalentTD);
    }

    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD_UE = 0;
        for (ServicePrevu service : servicePrev) {
            if (service.getUe().equals(ue)) {
                equivalentTD_UE += 1.5 * service.getVolumeCM();
                equivalentTD_UE += service.getVolumeTD();
                equivalentTD_UE += 0.75 * service.getVolumeTP();
            }

        }
        return Math.round(equivalentTD_UE);
    }

    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu sp = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue, this);
        servicePrev.add(sp);
    }
    
    public void ajouteIntervention (Salle s, UE ue, Enseignant e, Date debut, int duree, TypeIntervention type) {
        Intervention interv = new Intervention(s, ue, this, debut, duree, type);
        interventions.add(interv);
    }
    
    public boolean enSousService() {
        if (heuresPrevues()<192) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int heuresPlanifiees() {
        int heurePlan = 0;
        for (int i=0 ; i < interventions.size() ; i++) {
            switch (interventions.get(i).getType()) {
                case CM:
                    heurePlan += interventions.get(i).getDuree() * 1.5;
                    break;
                case TD:
                    heurePlan += interventions.get(i).getDuree();
                    break;
                case TP:
                    heurePlan += interventions.get(i).getDuree() * 0.75;
                    break;
                default :
                    break;
            }
        }
        return Math.round(heurePlan);
    }

}

