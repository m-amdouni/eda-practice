package com.techbank.account.cmd.api.commands;

import com.techbank.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class DepositFundCommand extends BaseCommand {
    private double amount;
}
