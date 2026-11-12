package com.chikodili.earlyconflictdetection;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LocalChangeTracker implements DocumentListener {

    private final Map<String, Set<Integer>> editedLines = new HashMap<>();

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        Document document = event.getDocument();
        VirtualFile file = FileDocumentManager.getInstance().getFile(document);
        if (file == null) {
            return;
        }
        int offset = event.getOffset();
        int line = document.getLineNumber(offset) + 1;
        String path = file.getPath();

        Set<Integer> lines = editedLines.get(path);
        if (lines == null) {
            lines = new TreeSet<>();
            editedLines.put(path, lines);
        }
        lines.add(line);

        System.out.println("Edited lines in " + file.getName() + ": " + lines);

    }
}