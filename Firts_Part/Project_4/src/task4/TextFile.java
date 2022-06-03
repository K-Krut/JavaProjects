package task4;

public class TextFile {

    private String absolutePath;
    private String description;

    public TextFile(String absolutePath, String description) {
        this.absolutePath = absolutePath;
        this.description = description;
    }

    public TextFile() {
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "absolutePath='" + absolutePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
