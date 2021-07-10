package me.rhys.methods;

import lombok.Getter;
import me.rhys.methods.impl.Manager;

@Getter
public class BetterMethods {
    @Getter private static BetterMethods instance;
    private final Manager manager = new Manager();

    public void register() {
        instance = this;
        this.manager.setup();
    }
}
