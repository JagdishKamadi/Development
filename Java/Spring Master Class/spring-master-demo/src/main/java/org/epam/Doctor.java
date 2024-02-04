package org.epam;

public class Doctor {

    private HelpService helpService;

    public void assist() {
        System.out.println("I am helping");
        helpService.extraHelp();
    }

    public void setHelpService(HelpService helpService) {
        this.helpService = helpService;
    }
}
