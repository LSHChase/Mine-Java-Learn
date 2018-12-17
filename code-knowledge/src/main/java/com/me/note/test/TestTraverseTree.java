package com.me.note.test;

import java.io.File;
import java.util.*;

public class TestTraverseTree {

    private static final String FILE_DIR = "/home/sx-9524/workspace/files";

    private Integer fileCount = 0;
    private Integer directoryCount = 0;

    private String rootDir;

    public void testAll(){
//        testRecursive(FILE_DIR);
        testDepthFirst();
//        testBreadthFirst();
        System.out.println("There are " + fileCount + " files.");
        System.out.println("There are " + directoryCount + " directories.");
    }

    /**
     * test recursive traverse tree
     * @param fileDir file directory
     */
    private void testRecursive(String fileDir){
        List<File> fileList = new ArrayList<>();
        File file = new File(fileDir);
        //get all files and directories below this file
        File[] files = file.listFiles();
        //if files is null, return it;
        if (null == file){
            return;
        }
        //traverse all files below files
        for (File f: files){
            if (f.isFile()){
                fileList.add(f);
            }else if (f.isDirectory()){
                System.out.println(f.getAbsolutePath());
                directoryCount ++;
                testRecursive(f.getAbsolutePath());
            }
        }

        for (File f1: fileList){
            System.out.println(f1.getPath());
            fileCount ++;
        }
    }

    /**
     * test depth first traverse tree
     */
    private void testDepthFirst(){
        Stack<File> fileStack = new Stack<>();
        File file = new File(FILE_DIR);
        rootDir = file.getAbsolutePath();
        fileStack.add(file);
        while (!fileStack.isEmpty()){
            file = fileStack.pop();
            if (file.isFile()) {
                System.out.println(file.getPath());
                fileCount ++;
            }
            if (file.isDirectory()){
                //if directory is not the root directory, print it.
                if (!rootDir.equals(file.getAbsolutePath())) {
                    System.out.println(file.getAbsolutePath());
                    directoryCount ++;
                }
                File[] files = file.listFiles();
                if (null != files && 0 != files.length) {
                    for (File f : files) {
                        fileStack.push(f);
                    }
                }
            }
        }
    }

    /**
     * test breadth first traverse tree
     */
    private void testBreadthFirst(){
        Queue<File> fileQueue = new LinkedList<>();
        File file = new File(FILE_DIR);
        rootDir = file.getAbsolutePath();
        fileQueue.add(file);
        while (!fileQueue.isEmpty()){
            file = ((LinkedList<File>) fileQueue).pop();
            if (file.isFile()){
                System.out.println(file.getPath());
                fileCount ++;
            }

            if (file.isDirectory()){
                if (!rootDir.equals(file.getAbsolutePath())){
                    System.out.println(file.getAbsolutePath());
                    directoryCount ++;
                }
                File[] files = file.listFiles();
                for (File f: files){
                    fileQueue.add(f);
                }
            }
        }
    }
}
