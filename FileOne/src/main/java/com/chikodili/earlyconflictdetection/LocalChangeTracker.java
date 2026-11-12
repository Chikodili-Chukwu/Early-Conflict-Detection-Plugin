package com.chikodili.earlyconflictdetection;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import org.jetbrains.annotations.NotNull;

public class LocalChangeTracker implements DocumentListener {

    public void documentChanged(@NotNull DocumentEvent event) {
        System.out.println("something changed");
    }
}