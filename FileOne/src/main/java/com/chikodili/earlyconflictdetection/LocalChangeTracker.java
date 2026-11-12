package com.chikodili.earlyconflictdetection;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import org.jetbrains.annotations.NotNull;

public class LocalChangeTracker implements DocumentListener {

    public void documentChanged(@NotNull DocumentEvent event) {
        Document document = event.getDocument();
        int offset = event.getOffset();
        int line = document.getLineNumber(offset) + 1;
        System.out.println(line);
    }
}