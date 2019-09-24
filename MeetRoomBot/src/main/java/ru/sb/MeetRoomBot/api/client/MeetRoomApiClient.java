package ru.sb.MeetRoomBot.api.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sb.MeetRoomBot.api.dto.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MeetRoomApiClient {

    @Value("${mrs.api.baseurl}")
    private String baseUrl;


    public List<UserDto> getAllUsers(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserDto>> response = restTemplate.exchange(baseUrl + "/getAllUser", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDto>>(){});
        return response.getBody();
    }

    public UserDto getUserByChannelId(Long channelId){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/bot/getCurrent").queryParam("channelId", channelId);
        ResponseEntity<UserDto> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<UserDto>(){});
        return response.getBody();
    }

}
