package com.dsu.chat;


import com.dsu.chat.redis.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class KKORestAPI {
    @Autowired
    RedisManager managers;

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

            if(utter.contains("Q")){
                String a = utter.replace("Q"," ").replace(":","");
                managers.setData("quetion",a);
            }
            String rtnStr = "";
            rtnStr = chatdata.response(chatdata.request(utter));
            /* 발화 처리 끝*/

            List<HashMap<String, Object>> outputs = new ArrayList<>();
            HashMap<String, Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();
            HashMap<String, Object> button = new HashMap<>();
            List<HashMap<String,Object>> quickReplies = new ArrayList<>();

            if(rtnStr.contains("키워드")){
                quickReplies = chatdata.list();
            }

            managers.getData(rtnStr);
            text.put("text", rtnStr);
            simpleText.put("simpleText", text);
            outputs.add(simpleText);

            Map<String,String> hash = managers.buttonData(rtnStr);

            if(hash != null){
                button.put("button", hash);
                outputs.add(button);
            }


            template.put("outputs", outputs);
            template.put("quickReplies", quickReplies);
            resultJson.put("version", "2.0");
            resultJson.put("template", template);

        } catch (Exception e) {

        }

        return resultJson;
    }
    @GetMapping(value = "/question") // 질문 목록
    public Set<String> getQuetion() {
        return managers.getData("question");
    }

    @PostMapping(value = "/question") // 질문 추가
    public void setQuetion(@RequestParam String data) {
        managers.setData("question",data);
    }

    @DeleteMapping(value = "/quetion/{data}") // 질문 삭제
    public void delQuetion(@PathVariable String data){
        managers.delData(data);
    }

    @GetMapping(value = "/text") // 채팅 데이터 목록
    public Set<String> getText(){
        return managers.getText();
    }

    @PostMapping(value = "/text") // 채팅 데이터 추가
    public void setText(@RequestParam String key, @RequestParam String value){
        managers.setText(key,value);
    }

    @GetMapping(value = "/text/detail/{data}") // 채팅 value 데이터
    public String getDetailText(@PathVariable String data) {
        return managers.getDetailText(data);

    }


}
