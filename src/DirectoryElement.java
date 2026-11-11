import java.util.ArrayList;
import java.util.List;

public class DirectoryElement implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements = new ArrayList<>();

    public DirectoryElement(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return List.copyOf(elements);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}