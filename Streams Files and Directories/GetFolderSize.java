package com.company;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\tasheva\\Downloads\\Java Advanced Labs and Exercises\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
