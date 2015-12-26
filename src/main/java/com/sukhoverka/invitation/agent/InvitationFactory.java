package com.sukhoverka.invitation.agent;

public class InvitationFactory {

    private static InvitationFactory instance;

    public static InvitationFactory getInstance(){
        if(instance == null){
            instance = new InvitationFactory();
        }
        return instance;
    }

    public String getGreetingFor(String event){
        String invitation;
        switch (event){
            case "birthday" :
                invitation = "We are glad to invite You to our company birthday! ";
                break;
            case "new year" :
                invitation = "We would like to start this year with you and celebrate it together!";
                break;
            default: throw new IllegalArgumentException("unsupported event name: " + event);
        }
        return invitation;
    }
}
