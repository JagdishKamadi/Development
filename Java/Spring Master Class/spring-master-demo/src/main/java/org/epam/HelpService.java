package org.epam;

import org.springframework.stereotype.Component;

@Component
public class HelpService {
    public void extraHelp() {
        System.out.println("I am here to do extra help");
    }
}
