import services.SevenZipArchiverImpl;
import services.ZipArchiverImpl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static final String SEVENZIP = "7z";
    public static final String ZIP = "zip";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File directory = new File("files");

        System.out.println("Enter the type of archive you want to create for the folder 'files' in /src\n(7z) for 7zip\n(zip) for zip");
        String archiveType = sc.nextLine();
        switch (archiveType) {
            case SEVENZIP:
                File archive = new File("archive.7z");
                SevenZipArchiverImpl sevenZipArchiver = new SevenZipArchiverImpl();
                sevenZipArchiver.archive(directory, archive);
                System.out.println("7zip Archive created in " + archive.getAbsolutePath());
                break;
            case ZIP:
                archive = new File("archive.zip");
                ZipArchiverImpl ZipArchiver = new ZipArchiverImpl();
                ZipArchiver.archive(directory, archive);
                System.out.println("zip Archive created in " + archive.getAbsolutePath());
                break;
            default:
                System.out.println("no such archive type");
        }
    }
}
