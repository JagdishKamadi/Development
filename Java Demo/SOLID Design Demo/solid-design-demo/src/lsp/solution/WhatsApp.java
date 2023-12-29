package lsp.solution;

// so with the help of Liskov substitution we are able to resolve the problem
// WhatsApp can be easily replace using the SocialMedia & SocialVideoCallManager
public class WhatsApp implements SocialMedia, SocialVideoCallManager {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
