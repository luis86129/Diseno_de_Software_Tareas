package com.mycompany.cruisebook_project.models;

public abstract class PersonalCrucero { 
    protected PersonalCrucero sucesor;

    public void setSucesor(PersonalCrucero sucesor) {
        this.sucesor = sucesor;
    }

    public abstract void procesarIncidente(TicketIncidente ticket);
}