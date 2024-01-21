package com.epam.lsp.Solution;

public interface SmartPhoneService extends IPodService{
    void sendSMS();
    void call();
    void playVideo(String vidoeFileName);
}
