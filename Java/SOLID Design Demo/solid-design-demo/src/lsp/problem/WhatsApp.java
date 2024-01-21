package lsp.problem;


// but WhatsApp doesn't support  the publishPost
// WhatsApp doesn't replace the social media class
// here we have to apply the Liskov Substitution Principle
public class WhatsApp extends SocialMedia {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {
// Not Applicable
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
