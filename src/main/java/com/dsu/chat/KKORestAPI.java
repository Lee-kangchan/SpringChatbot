package com.dsu.chat;


import com.dsu.chat.Service.ChatObject;
import com.dsu.chat.redis.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class KKORestAPI {
    @Autowired
    RedisManager managers;
    private static final Logger logger = LoggerFactory.getLogger(KKORestAPI.class);

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
                managers.setData("question",a);
            }
            String rtnStr = "";
            rtnStr = chatdata.request(utter);
            /* 발화 처리 끝*/
            Set<String> rtn = new HashSet<>();
            rtn = managers.getData("text");

            int count = 0;
                for (String i : rtn) {
                    if (i.contains(utter)) {
                        count++;
                        rtn = managers.getData(i);
                        utter.replace("Q:" , "");
                        break;
                    }
                }


            logger.info(utter);
            if(utter.contains("Q")){
                if(managers.adminYN().equals("0")) {
                    rtnStr = managers.getResponse("질문");
                }
                else {
                    rtnStr = managers.getResponse("관리자가존재");
                }
            }
            else if(count ==0){
                 rtnStr = managers.getResponse("없음");
            }else{
                for(String i : rtn){
                    rtnStr = managers.getResponse(i);
                }
            }
            logger.info(rtnStr);
            List<HashMap<String, Object>> outputs = new ArrayList<>();
            HashMap<String, Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();
            List<HashMap<String, Object>> button = new ArrayList<>();
            List<HashMap<String,Object>> quickReplies = new ArrayList<>();

            if(rtnStr.contains("키워드")){
                quickReplies = chatdata.list();
            }

            rtnStr = chatdata.response(rtnStr);

            text.put("text", rtnStr);


            simpleText.put("simpleText", text);
            outputs.add(simpleText);

            template.put("outputs", outputs);
            template.put("quickReplies", quickReplies);
            resultJson.put("version", "2.0");
            resultJson.put("template", template);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultJson;
    }
    @PostMapping(value = "/login")
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw){
        if(id.equals("admin"))
        {
            if(pw.equals("manager")){
                managers.login();
                return "1";
            }
        }
        return "0";
    }
    @GetMapping(value = "/admin")
    public String admin() {

        return managers.admin();
    }
    @GetMapping(value = "/reset")
    public  void reset(){
        managers.reset();
    }
    @GetMapping(value = "/question") // 질문 목록
    public List<String> getQuestion() {
        List<String> question = new ArrayList<>();
        Set<String> data = managers.getData("question");
        for(String i : data){
            question.add(i);
        }
        return question;
    }


    @DeleteMapping(value = "/question/{question}") // 질문 삭제
    public void delQuetion(@PathVariable String question){
        logger.info("질문의 답은 ? "+question);
        managers.delData("question",question);
    }

    @GetMapping(value = "/text") // 채팅 데이터 목록
    public List<Map<String, Object>> getText(){

        return managers.chat();
    }

    @PutMapping(value = "/text")
    public void putText(@RequestBody ChatObject chat){
        managers.putData(chat.getKey(), chat.getValue());
    }

    @PostMapping(value = "/text", consumes = "application/json", produces = "application/json") // 채팅 데이터 추가
    public void setText(@RequestBody ChatObject data){
        ChatData chatData = new ChatData();
        logger.info(data.getKey());
        logger.info(data.getValue());
        String[] label = data.getKey().split("#");
        int i =0;
        for(i =1 ; i< label.length; i++) {
            logger.info(label[i]);
            managers.setData("text",  label[i]);
            managers.setResponse(label[i], data.getValue());
        }

    }
    @DeleteMapping(value = "/text/{data}")
    public void delText(@PathVariable String data){
        managers.delData("text",data);
        managers.delResponse(data);
    }
}
