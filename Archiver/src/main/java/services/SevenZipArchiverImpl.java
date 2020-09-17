package services;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SevenZipArchiverImpl implements Archiver {
    public void archive(File directory, File archive) throws IOException {
        SevenZOutputFile sevenZFile = new SevenZOutputFile(archive);
        File[] files = directory.listFiles();
        for (File f : files) {
            SevenZArchiveEntry entry = sevenZFile.createArchiveEntry(f, f.getName());
            sevenZFile.putArchiveEntry(entry);
            sevenZFile.write(FileUtils.readFileToByteArray(f));
            sevenZFile.closeArchiveEntry();
        }
        sevenZFile.finish();
    }
}
