package com.javadayistanbul.patterns.classic.command;

import java.util.ArrayList;
import java.util.List;

public class OrderCommandInvoker {
    private final List<OrderCommand> history = new ArrayList<>();

    public void executeCommand(OrderCommand command) {
        command.execute();
        history.add(command);
    }

    public List<OrderCommand> getHistory() {
        return List.copyOf(history);
    }

    public int getHistorySize() {
        return history.size();
    }
}
