package com.vk.service;

import com.vk.api.sdk.queries.messages.MessagesCreateChatQuery;

import java.util.List;

public interface PrepareChatService {
    MessagesCreateChatQuery prepareChat(String title);
    MessagesCreateChatQuery prepareChatWithUserIds(String title, List<Integer> userIds);
    MessagesCreateChatQuery prepareChatWithAccessToken(String title, String accessToken);
    MessagesCreateChatQuery prepareChatWithGroupId(String title, int groupId);
}
