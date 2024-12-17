package id.my.khafidprayoga;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

abstract class BaseFIleReader {
    protected Path filepath;

    protected BaseFIleReader(Path filepath) {
        this.filepath = filepath;
    }

    public Path getFilepath() {
        return this.filepath;
    }

    public List<String> readFile() throws IOException {
        return Files.lines(filepath).map(this::mapFileLine).collect(Collectors.toList());
    }

    protected abstract String mapFileLine(String line);
}

class LowecaseFileReader extends BaseFIleReader {
    public LowecaseFileReader(Path filepath) {
        super(filepath);
    }

    @Override
    protected String mapFileLine(String line) {
        return line.toLowerCase();
    }
}
