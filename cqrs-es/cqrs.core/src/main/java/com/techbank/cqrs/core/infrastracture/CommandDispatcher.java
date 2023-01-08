package com.techbank.cqrs.core.infrastracture;

import com.techbank.cqrs.core.commands.BaseCommand;
import com.techbank.cqrs.core.commands.CommandHandlerMethod;
import com.techbank.cqrs.core.events.BaseEvent;

public interface CommandDispatcher {
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    public void send(BaseCommand command);
}
