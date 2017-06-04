package com.zhyshkevich.services.interfaces;

import com.zhyshkevich.services.dto.ClientDto;

/**
 * Created by Сергей on 31.05.2017.
 */
public interface ClientService extends BaseService<ClientDto> {

    int login (ClientDto clientDto);
}
