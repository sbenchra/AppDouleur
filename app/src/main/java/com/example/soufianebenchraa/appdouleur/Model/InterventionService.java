package com.example.soufianebenchraa.appdouleur.Model;

import java.lang.reflect.Type;
import java.util.List;

public class InterventionService {

    int idtypeinterventionservice;
    TypeIntervention typeintervention;
    Service service;

    public InterventionService(int idtypeinterventionservice, TypeIntervention typeintervention, Service service) {
        this.idtypeinterventionservice = idtypeinterventionservice;
        this.typeintervention = typeintervention;
        this.service = service;
    }

    public int getIdtypeinterventionservice() {
        return idtypeinterventionservice;
    }

    public void setIdtypeinterventionservice(int idtypeinterventionservice) {
        this.idtypeinterventionservice = idtypeinterventionservice;
    }

    public TypeIntervention getTypeintervention() {
        return typeintervention;
    }

    public void setTypeintervention(TypeIntervention typeintervention) {
        this.typeintervention = typeintervention;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
