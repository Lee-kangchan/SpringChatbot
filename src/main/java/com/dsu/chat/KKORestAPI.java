package com.dsu.chat;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KKORestAPI {

    //카카오톡 오픈빌더로 리턴할 스킬 API
    @RequestMapping(value = "/kkoChat/v1", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept=application/json"})
    public HashMap<String, Object> callAPI(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            System.out.println(jsonInString);

            ChatData chatdata = new ChatData();
            /* 발화 처리 부분 * */
            HashMap<String, Object> userRequest = (HashMap<String, Object>) params.get("userRequest");
            String utter = userRequest.get("utterance").toString().replace("\n", "");

            String rtnStr = "";
            rtnStr = chatdata.response(chatdata.request(utter));
            /* 발화 처리 끝*/

            List<HashMap<String, Object>> outputs = new ArrayList<>();
            HashMap<String, Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();

            List<HashMap<String,Object>> quickReplies = new ArrayList<>();

            if(rtnStr.contains("키워드")){
                quickReplies = chatdata.list();
            }

            text.put("text", rtnStr);
            simpleText.put("simpleText", text);
            outputs.add(simpleText);

            template.put("outputs", outputs);
            template.put("quickReplies", quickReplies);
            resultJson.put("version", "2.0");
            resultJson.put("template", template);

        } catch (Exception e) {

        }

        return resultJson;
    }
}
