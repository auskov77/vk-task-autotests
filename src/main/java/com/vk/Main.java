package com.vk;

import com.vk.api.sdk.actions.Messages;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.queries.messages.MessagesCreateChatQuery;
import com.vk.util.Props;

public class Main {
    public static void main(String[] args) {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        int groupId = Integer.parseInt(Props.getProperty("groupId"));
        int userIds = Integer.parseInt(Props.getProperty("userIds"));
        String accessToken = Props.getProperty("accessToken");
        String title = "title";
    }
    public static int createChat(int groupId, VkApiClient vk, String accessToken, String title, int userIds) throws ClientException, ApiException {
        GroupActor groupActor = new GroupActor(groupId, accessToken);
        Messages messages = new Messages(vk);
        MessagesCreateChatQuery chat = messages.createChat(groupActor);
        return chat.title(title).userIds(userIds).execute();
    }
}
