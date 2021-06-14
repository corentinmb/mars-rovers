package fr.corentinmb.infra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MissionReader {

    private MissionReader() {
    }

    public static RawMissionValues readMission(String absoluteFilePath) throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Paths.get(absoluteFilePath), StandardCharsets.UTF_8);
        return MissionReaderMapper.map(lines);
    }
}
