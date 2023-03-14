package com.code.basic.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.code.basic.transaction.domain.AccountDomain;

/**
* @author FengDuo
* @description 针对表【account】的数据库操作Service
* @createDate 2023-03-08 17:08:06
*/
public interface AccountService extends IService<AccountDomain> {

    String multiOrderTransaction();

    AccountDomain getAccountDomain();
}
