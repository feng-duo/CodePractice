package com.code.basic.designpattern.command;

import org.junit.Test;

/**
 * @author FengDuo
 * @date 2022/12/28 15:15
 */
public class CommandTest {

    @Test
    public void LightCommandTest(){
        RemoteController remoteController = new RemoteController();
        Light light = new Light();
        remoteController.setCommand(new LightOnCommand(light));
        remoteController.pressButton();
        remoteController.setCommand(new LightOffCommand(light));
        remoteController.pressButton();
    }
}
