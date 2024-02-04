package org.epam;

import org.springframework.stereotype.Component;

@Component
public class Doctor {

    private HelpService helpService;

    public Doctor(HelpService helpService) {
        this.helpService = helpService;
    }

    public void assist() {
        System.out.println("I am helping");
        helpService.extraHelp();
    }

    public void setHelpService(HelpService helpService) {
        this.helpService = helpService;
    }
}
