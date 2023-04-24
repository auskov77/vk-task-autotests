package com.vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MessagesCreateChatPositiveTest extends BaseTest{
    @DataProvider(parallel = true)
    public Object[][]  concurrencyData() {
        return new Object[][]  {
                {"1"}, {"TEST_CORRECT_CHAT"}, {"!@#$%^(&*()"}};
    }

    @Test(dataProvider = "concurrencyData")
    public void shouldHaveCorrectCreateChat(String title) throws ClientException, ApiException {
        log.info("Создаем корректный чат");
        Integer chatId = PREPARE_CHAT_SERVICE.prepareChat(title).execute();
        log.info("Проверяем, что chatID не пуст");
        Assert.assertNotNull(chatId);
    }
}
