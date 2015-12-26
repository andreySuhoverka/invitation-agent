package com.sukhoverka.invitation.agent;

import java.io.Console;

public class InvitationAgent {

    private String templateName;
    private String email;
    private String event;

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sendInvitation() {
        String greeting = "Dear, " + templateName + "!\n";
        String baseText = getBaseTextByEvent(event);
        String invitation = greeting + baseText;
        Console console = System.console();
        if (console == null) {
            throw new ExceptionInInitializerError("There is no console available");
        }
        console.format("\nInvitation text: \n" + invitation);
        console.format("\nType 'yes' to confirm sending or 'no' to reject\n");
        String userInput = console.readLine();
        if("yes".equals(userInput)){
            // send invitation here
            console.format("Successfully sent invitation to " + email + " !");
        }
    }

    private String getBaseTextByEvent(String event) {
        return InvitationFactory.getInstance().getGreetingFor(event);
    }
}
