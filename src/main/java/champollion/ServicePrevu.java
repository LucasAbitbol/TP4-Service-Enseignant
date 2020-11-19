package champollion;

public class ServicePrevu {
    
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private UE ue;
    private Enseignant prof;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue, Enseignant prof) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue= ue;
        this.prof = prof;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getProf() {
        return prof;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setProf(Enseignant prof) {
        this.prof = prof;
    }
    
    

}
