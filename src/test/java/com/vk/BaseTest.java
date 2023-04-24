package com.vk;

import com.vk.service.PrepareChatService;
import com.vk.service.PrepareChatServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    public final static PrepareChatService PREPARE_CHAT_SERVICE = new PrepareChatServiceImpl();
    public final Logger log = LoggerFactory.getLogger(BaseTest.class);
}
