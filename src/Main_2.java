import java.util.ArrayList;
import java.util.List;
abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display();
    public abstract int getSize();
}


class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("File: " + name + ", Size: " + size + " KB");
    }

    @Override
    public int getSize() {
        return size;
    }
}


class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        if (!components.contains(component)) {
            components.add(component);
        }
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class Main_2 {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);

        Directory subDirectory = new Directory("subDirectory");
        File file3 = new File("file3.txt", 30);

        root.addComponent(file1);
        root.addComponent(file2);
        subDirectory.addComponent(file3);
        root.addComponent(subDirectory);

        root.display();
        System.out.println("Total size of root directory: " + root.getSize() + " KB");
    }
}
