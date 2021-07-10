package me.rhys.methods.impl;

import lombok.Getter;
import me.rhys.methods.api.abstraction.MethodAbstraction;
import me.rhys.methods.impl.versions.v1_7.Version1_7_R4;
import me.rhys.methods.impl.versions.v1_8.Version1_8_R1;
import me.rhys.methods.impl.versions.v1_8.Version1_8_R2;
import me.rhys.methods.impl.versions.v1_8.Version1_8_R3;
import org.bukkit.Bukkit;

@Getter
public class Manager {
    private MethodAbstraction methodAbstraction;

    public void setup() {
        String version = Bukkit.getServer().getClass().getPackage().getName().substring(23);

        switch (version) {
            case "v1_8_R3": {
                this.methodAbstraction = new Version1_8_R3();
                break;
            }

            case "v1_8_R2": {
                this.methodAbstraction = new Version1_8_R2();
                break;
            }

            case "v1_8_R1": {
                this.methodAbstraction = new Version1_8_R1();
                break;
            }

            case "v1_7_R4": {
                this.methodAbstraction = new Version1_7_R4();
                break;
            }
        }
    }
}
