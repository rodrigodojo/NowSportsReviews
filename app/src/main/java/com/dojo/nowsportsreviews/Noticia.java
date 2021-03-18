package com.dojo.nowsportsreviews;

public class Noticia {

    public String timeCasa, timeVisitante, siglaCasa, siglaVisitante, placar;

    public Noticia(String timeCasa, String timeVisitante, String siglaCasa, String siglaVisitante, String placar) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.siglaCasa = siglaCasa;
        this.siglaVisitante = siglaVisitante;
        this.placar = placar;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public String getSiglaCasa() {
        return siglaCasa;
    }

    public void setSiglaCasa(String siglaCasa) {
        this.siglaCasa = siglaCasa;
    }

    public String getSiglaVisitante() {
        return siglaVisitante;
    }

    public void setSiglaVisitante(String siglaVisitante) {
        this.siglaVisitante = siglaVisitante;
    }

    public String getPlacar() {
        return placar;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }

}
