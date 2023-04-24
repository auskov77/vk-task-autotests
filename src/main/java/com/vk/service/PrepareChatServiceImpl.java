package com.vk.service;

import com.vk.api.sdk.actions.Messages;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.queries.messages.MessagesCreateChatQuery;
import com.vk.util.Props;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrepareChatServiceImpl implements PrepareChatService{
    private final TransportClient transportClient = new HttpTransportClient();
    private final VkApiClient vk = new VkApiClient(transportClient);
    private final Messages messages = new Messages(vk);
    private final static String DEFAULT_ACCESS_TOKEN = Props.getProperty("accessToken");
    private final static int DEFAULT_GROUP_ID = Integer.parseInt(Props.getProperty("groupId"));
    private final static List<Integer> DEFAULT_USER_IDS = Stream.of(Props.getProperty("userIds").split(","))
            .map(Integer::parseInt).collect(Collectors.toList());

    @Override
    public MessagesCreateChatQuery prepareChat(String title) {
        return createChatWithDefaultGroupIdAndToken().title(title).userIds(DEFAULT_USER_IDS);
    }

    @Override
    public MessagesCreateChatQuery prepareChatWithUserIds(String title, List<Integer> userIds) {
        return createChatWithDefaultGroupIdAndToken().title(title).userIds(userIds);
    }

    @Override
    public MessagesCreateChatQuery prepareChatWithAccessToken(String title, String accessToken) {
        return messages.createChat(new GroupActor(DEFAULT_GROUP_ID, accessToken))
                .title(title).userIds(DEFAULT_USER_IDS);
    }

    @Override
    public MessagesCreateChatQuery prepareChatWithGroupId(String title, int groupId) {
        return messages.createChat(new GroupActor(groupId, DEFAULT_ACCESS_TOKEN))
                .title(title).userIds(DEFAULT_USER_IDS);
    }

    private MessagesCreateChatQuery createChatWithDefaultGroupIdAndToken() {
        return messages.createChat(new GroupActor(DEFAULT_GROUP_ID, DEFAULT_ACCESS_TOKEN));
    }
}
