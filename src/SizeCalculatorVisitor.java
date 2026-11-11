public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSizeInKb = 0;

    @Override
    public void visitFile(FileElement file) {
        totalSizeInKb += file.getSizeInKb();
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
    }

    public int getTotalSizeInKb() {
        return totalSizeInKb;
    }
}