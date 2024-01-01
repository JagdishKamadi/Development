package some_complex_media_library;

public class VideoFile {
    private String name;
    private String codeType;

    public VideoFile(String name) {
        this.name = name;
        this.codeType = this.name.substring(name.indexOf('.') + 1);
    }

    public String getName() {
        return this.name;
    }

    public String getCodeType() {
        return this.codeType;
    }
}
