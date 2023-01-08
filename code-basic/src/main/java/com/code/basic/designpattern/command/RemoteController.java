package com.code.basic.designpattern.command;

import lombok.Data;

/**
 * @author FengDuo
 * @date 2022/12/28 15:12
 */
@Data
public class RemoteController {

    private Command command;

    /**
     * 执行命令
     */
    public void pressOnButton(){
        command.execute();
    }

    /**
     * 撤销命令
     */
    public void pressOffButton(){
        command.undo();
    }
}
