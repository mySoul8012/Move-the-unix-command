package com.ming.tools;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

public class FindJavaVisitor extends SimpleFileVisitor<Path> {
    private Path dir;
    private List<Path> result;

    public FindJavaVisitor(Path _dir, List<Path> result){
        this.dir = _dir;
        this.result = result;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException{
        result.add(dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
