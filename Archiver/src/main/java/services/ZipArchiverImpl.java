package services;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class ZipArchiverImpl implements Archiver {
    public void archive(File directory, File archive) throws ZipException {
        new ZipFile(archive).addFolder(directory);
    }
}
