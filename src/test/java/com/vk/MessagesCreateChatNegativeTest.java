package com.vk;

import com.vk.api.sdk.exceptions.ApiException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MessagesCreateChatNegativeTest extends BaseTest{
    @Test
    public void shouldNotCreateChatWithEmptyTitle() {
        log.info("Создаем чат с пустым полем title и ожидаем получить исключение ApiException");
        Assert.assertThrows(ApiException.class, PREPARE_CHAT_SERVICE.prepareChat("")::execute);
    }
    @Test
    public void shouldNotCreateChatWithBadUserIds() {
        log.info("Создаем чат с некорректными id-шниками пользователей и ожидаем получить исключение ApiException");
        Assert.assertThrows(ApiException.class,
                PREPARE_CHAT_SERVICE.prepareChatWithUserIds("TEST_BAD_USER_IDS", List.of(123, 233))::execute);
    }
    @Test
    public void shouldNotCreateChatWithBadAccessToken() {
        log.info("Создаем чат с некорректным access token и ожидаем получить исключение ApiException");
        Assert.assertThrows(ApiException.class,
                PREPARE_CHAT_SERVICE.prepareChatWithAccessToken("TEST_BAD_ACCESS_TOKEN", "bad_token")::execute);
    }

    @Test
    public void shouldNotCreateChatWithBadGroupId() {
        log.info("Создаем чат с некорректным group Id и ожидаем получить исключение ApiException");
        Assert.assertThrows(ApiException.class,
                PREPARE_CHAT_SERVICE.prepareChatWithGroupId("TEST_BAD_GROUP_ID", 1)::execute);
    }
}
