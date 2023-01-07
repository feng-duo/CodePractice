package com.code.basic.designpattern.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FengDuo
 * @date 2022/12/28 15:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LightOffCommand implements Command{

    private Light light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
