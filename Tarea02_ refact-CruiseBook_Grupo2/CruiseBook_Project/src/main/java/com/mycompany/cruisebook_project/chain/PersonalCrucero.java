package com.mycompany.cruisebook_project.chain;

import com.mycompany.cruisebook_project.models.TicketIncidente;

public abstract class PersonalCrucero { 
    protected PersonalCrucero sucesor;

    public void setSucesor(PersonalCrucero sucesor) {
        this.sucesor = sucesor;
    }

    public abstract void procesarIncidente(TicketIncidente ticket);
}