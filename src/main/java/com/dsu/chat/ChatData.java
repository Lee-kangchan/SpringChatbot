package com.dsu.chat;

import com.dsu.chat.redis.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.*;

@Controller
public class ChatData {
    private static final Logger logger = LoggerFactory.getLogger(ChatData.class);

    @Autowired
    RedisManager manager;

    public String request(String data){
        data.replace(" ",  "");
        if(data.contains("소프트웨어학과")||data.contains("소프트웨어")||data.contains("소웨")){
            if(data.contains("컴퓨터공학과")||data.contains("컴공")){
                if(data.contains("다른점")||data.contains("차이")){
                    return "소웨컴공차이";
                }
            }
            if(data.contains("장점")||data.contains("좋은점")){
                return "소웨장점";
            }
            if(data.contains("지원해야")||data.contains("인재상")){
                return "소웨인재상";
            }

        }
        if(data.contains("배움")||data.contains("배우")||data.contains("가르")||data.contains("교육")||data.contains("배워")){return "배움";}
        if(data.contains("행사")||data.contains("축제")){ return "행사";}
        if(data.contains("진로")||data.contains("취업")){return "진로";}
        if(data.contains("시설")){return "시설";}
        if(data.contains("미리")||data.contains("준비")||(data.contains("가기 전"))){return "준비";}
        if(data.contains("프로젝트")){return "프로젝트";}
        if(data.contains("기숙사")){return "기숙사";}
        if(data.contains("도서관")){return "도서관";}
        if(data.contains("상담신청")){return "상담신청";}
        if(data.contains("키워드")){return "키워드";}
        if(data.contains("튜터링")){return "튜터링";}
        if(data.contains("분위기")){return "분위기";}
        if(data.contains("장학금")){return "장학금";}
        if(data.contains("지원")){return "지원";}
        if(data.contains("Q")){
            String a = data.replace("Q"," ").replace(":","");

            return "질문";}

        return "없음";
    }
    public String response(String data){
        if(data.contains("행사")){
            return "행사 종류  \n" +
                    "1. 튜터링 : (신입생 강추) 고학년 선배들이 저학년 후배들을 도움을 주는 프로그램\n\n" +
                    "2. 아이디어 경진대회 : 주로 AI와 SW를 연동한 아이디어를 가지고 발표 \n\n" +
                    "3. 해커톤 경진대회 : 아이디어 상품을 직접 개발하는 대회\n\n " +
                    "4. 기업 견학 : 다양한 기업들을 견학하는 행사\n\n " +
                    "이 외에 다양한 행사가 있어요 (행복) ";
        }
        else if(data.contains("진로")){
            return "소프트웨어 학과에서는 주로 웹 개발, 앱 개발 개발 쪽을 취업을 하고 있으며\n " +
                    "최근에 AI 관련된 것들이 많이 나와서 AI 전문가, 데이터 과학자 등 다양하게 진로를 선택 할 수 있어요 " +
                    "어디서나 소프트웨어가 사용되어 취업 분야는 굉장히 넓어요\n" +
                    "저희 과 졸업생은 삼성SDS, LG전자, KAKAO 외에서도 매년 연세대, 고려대, 부산대 등 대학원에 진학하고 있어요 ";
        }
        else if(data.contains("시설")){
            return "시설은 실습을 하는 공간은 컴퓨터가 전부 설치 되어있으며 " +
                    "공부 할 수 있는 공간도 많고 연구실에 들어가면 개인 자리와 컴퓨터를" +
                    "지급 되어 편히 공부 할 수 있어요";
        }
        else if(data.contains("준비")){
            return "학교 오기전 하면 좋은 것들은 아마 처음 배우는 컴퓨터 언어는 Python 이라는 언어를 배울거에요" +
                    "C언어나 Python을 미리 학습을 해서 다양한 사고를 하기위해 다양한 알고리즘 문제를 많이 푸는 것을 추천해요 \n" +
                    "그리고 또 하나 추천은 html css javascript를 가지고 웹페이지를 만드는 것도 추천해요 Youtube에" +
                    "좋은 영상이 올라오니 한번 참고 해보세요";
        }
        else if(data.contains("프로젝트")){
            return "프로젝트는 소프트웨어학과 홈페이지에서 선배들이 진행했던 프로젝트 목록들을 볼 수 있어요:)" +
                    "언젠가는 비슷한 프로젝트를 진행 할테니 참고하면 좋겠죠??  ";
        }
//        else if(data.contains("기숙사")){
//            return "기숙사는 학생생활아파트 기숙사와 글로벌 빌리지 두 기숙사가 있어요" +
//                    "\n\n 1.학생생활아파트 : 아파트 1동에 방이 3개 정두 있는데 2인실 1인실 3인실로 되어 있으며 침대 책상 옷장을 개인으로 가지며 샤워 같은 것은 공용으로 사용해야되요 " +
//                    "세탁기, 냉장고, 전자레인지 같은 것은 기숙사 안에 없으며  조리실과 세탁실은 다른 동에 공용으로 사용하는 곳이 있어요" +
//                    "\n\n 2.글로벌빌리지 : 글로벌빌리지는 전부 2인실로 되어 있으며 가격이 20만원? 정도 비싸니깐 학생생활아파트보다는 시설이 좀 더 좋을 거에요 포함하는 건 학생 생활" +
//                    "아파트랑 비슷하며 조리실은 없어요  " +
//                    "\n\n 자세한 것은 학교 홈페이지를 참고해주세요 :)";
//        }
//        else if(data.contains("도서관")){
//            return "도서관 대한 정보는 없어 동서대학교 민석도서관 홈페이지를 한번 참고해보세요 ㅠㅠ ";}
        else if(data.contains("키워드")){return "키워드";}
//        else if(data.contains("팁")){return "팁";}
//        else if(data.contains("분위기")){return " ";}
        else if(data.contains("소웨컴공차이")){
            return "소프트웨어학과와 컴퓨터공학부 차이\n\n" +
                    "컴퓨터공학부는 운영체제, 컴퓨터구조, 하드웨어, 자료구조, 소프트웨어를 같이 공부하는 학과에요\n\n" +
                    "소프트웨어학과는 소프트웨어를 개발하기 위한 데이터베이스, 프로그래밍언어 등의 기초 및 고급 이론과 함께 소프트웨어 설계를 위한 전문 기술을 공부하는 학과에요 ";
        } else if(data.contains("소웨장점")){
            return "소웨 장점 \n" +
                    "첫번째는 인공지능 전문 분야를 공부할 수 있어요\n" +
                    "1~3학년에 SW개발 설계를 공부한 후 자연스럽게 3~4학년 때 AI 심화트랙에서 인공지능 전문 기술을 배울 수 있어요\n\n " +
                    "두번째는 대학과 산업계의 스킬갭 제로 교육을 해요 \n" +
                    "취업해두 실무를 몰라서 다시 공부하는 경우가 많아요 그래서 캡스톤디자인, 클래스프로젝트라는 산학프로젝트를" +
                    "진행하면서 SW개발 실무능력을 키워요 \n\n" +
                    "마지막으로 연구회를 기반으로 한 활발한 학생활동 이에요 \n" +
                    "각 교수님 별로 연구회가 있어서 모든 학생을 연구회에 가입하도록 유도해서 교수님의 지도하" +
                    "에 프로젝트를 수행하고 결과물을 외부에 발표하도록 해요 ";
        } else if(data.contains("소웨인재상")){
            return "인공지능 개발자, 소프트웨어 개발자를 생각하고 있는 학생이면 누구든지 지원 가능합니다!\n\n" +
                    "특히 올해 SW융합인재 전형이 생기면서 10명만 모집하며 해당전형 합격자는 전액 특별장학금과 해외 인턴십, 고성능 노트북 지급 등의 여러 혜택을 " +
                    "주어질 예정이에요";
        } else if(data.contains("장학금")){
            return "기본적으로 너무 많은 장학금이 있어서 핵심적인 장학금만 소개해줄게요 \n\n" +
                    "첫번째는 성적장학금 성적을 잘받은 일부분만 순서대로 장학금을 주는 제도에요 \n\n" +
                    "두번째는 AI심화트랙을 참여하면 지급하는 우수학생 장학금 \n\n" +
                    "세번째는 SW튜터링 우수장학으로 SW전공자 중에서 튜터링의 튜터에게 지급해주는 장학 \n\n" +
                    "네번째는 SW연계전공에 참여하는 학생에게 지급되는 SW연계전공우수학생 장학생\n\n" +
                    "마지막으로 참여가 높을수록 장학금을 주는 스마일리지 장학금\n\n" +
                    "이것 말고도 많은 장학금 종류가 있어요 (행복)";
        } else if(data.contains("배움")){
            return "저의 학과에서 1학년 때는 주로 다양한 교양배우며 \n" +
                    "2학년때는 기초 프로그래밍언어나 자료구조, 네트워크, 이산수학을 배워요\n" +
                    "3학년때는 인공지능, 소프트웨어 분석 및 설계 , 데이터베이스를 배우며\n" +
                    "4학년때는 빅데이터 인공지능 심화적인 과목을 배우며 이때까지 배운 것으로 졸업작품을 만들어요";
        } else if(data.contains("지원")){
            return "저희 과가 중심운영학과 이라 학생들이 입학하면 이런 지원을 해줍니다.\n" +
                    "첫번째는 전공튜터링, 산학프로젝트 운영 등에 있어 적극적인 지원을 해줘요 \n" +
                    "두번째는 6개월간 미국에 가는 미국 SAP\n" +
                    "세번째는 미국 CES와 연계한 2주 국제인턴십프로그램\n" +
                    "마지막은 캘리포니아 산호세대학 4주 인턴십 프로그램\n" +
                    "해외에서 인턴십을 해보고 싶은 학생은 참 좋겠죠??";
        } else if(data.contains("질문")) {
            return "아직 운영되지 않아요 ㅠㅠ 질문을 원하시면 해당 버튼을 눌러 질문을 해주시길 바랍니다. ";
        }
        else{
            return"해당내용에 답변이 없어요... 답변을 얻고 싶으면 \"Q:내용\"으로 남겨주세요 2일내에 해당 답변을 등록하겠습니다 \n\n" +
                    "ex) Q:Hello";}
    }
    public List<HashMap<String,Object>> list(){
        List<HashMap<String,Object>> quickReplies = new ArrayList<>();
        HashMap<String,Object> quickRepl = new HashMap<>();
        quickRepl.put("action","message");
        quickRepl.put("label","행사");
        quickRepl.put("messageText","행사");
        quickReplies.add(quickRepl);

        HashMap<String,Object> quickRepl2 = new HashMap<>();
        quickRepl2.put("action","message");
        quickRepl2.put("label","진로");
        quickRepl2.put("messageText","진로");
        quickReplies.add(quickRepl2);

        HashMap<String,Object> quickRepl3 = new HashMap<>();
        quickRepl3.put("action","message");
        quickRepl3.put("label","시설");
        quickRepl3.put("messageText","시설");
        quickReplies.add(quickRepl3);

        HashMap<String,Object> quickRepl4 = new HashMap<>();
        quickRepl4.put("action","message");
        quickRepl4.put("label","준비 하면 좋은 것");
        quickRepl4.put("messageText","준비");
        quickReplies.add(quickRepl4);

        HashMap<String,Object> quickRepl5 = new HashMap<>();
        quickRepl5.put("action","message");
        quickRepl5.put("label","선배들의 프로젝트");
        quickRepl5.put("messageText","프로젝트");
        quickReplies.add(quickRepl5);

        HashMap<String,Object> quickRepl6 = new HashMap<>();
        quickRepl6.put("action","message");
        quickRepl6.put("label","지원");
        quickRepl6.put("messageText","지원");
        quickReplies.add(quickRepl6);

        HashMap<String,Object> quickRepl7 = new HashMap<>();
        quickRepl7.put("action","message");
        quickRepl7.put("label","소웨학과와 컴공차이");
        quickRepl7.put("messageText","소웨컴공차이");
        quickReplies.add(quickRepl7);

        HashMap<String,Object> quickRepl8 = new HashMap<>();
        quickRepl8.put("action","message");
        quickRepl8.put("label","학과장점");
        quickRepl8.put("messageText","소웨장점");
        quickReplies.add(quickRepl6);

        HashMap<String,Object> quickRepl9 = new HashMap<>();
        quickRepl9.put("action","message");
        quickRepl9.put("label","소웨인재상");
        quickRepl9.put("messageText","소웨인재상");
        quickReplies.add(quickRepl9);

        HashMap<String,Object> quickRepl10 = new HashMap<>();
        quickRepl10.put("action","message");
        quickRepl10.put("label","배우는 것");
        quickRepl10.put("messageText","배움");
        quickReplies.add(quickRepl10);

        HashMap<String,Object> quickRepl11 = new HashMap<>();
        quickRepl11.put("action","message");
        quickRepl11.put("label","장학금");
        quickRepl11.put("messageText","장학금");
        quickReplies.add(quickRepl11);

//        HashMap<String,Object> quickRepl12 = new HashMap<>();
//        quickRepl12.put("action","message");
//        quickRepl12.put("label","기숙사");
//        quickRepl12.put("messageText","기숙사");
//        quickReplies.add(quickRepl12);
//
//        HashMap<String,Object> quickRepl13 = new HashMap<>();
//        quickRepl13.put("action","message");
//        quickRepl13.put("label","기숙사");
//        quickRepl13.put("messageText","기숙사");
//        quickReplies.add(quickRepl13);



        return quickReplies;
    }
    public Map<String, String> button2(String data){
        Map<String, String> hash = new HashMap<>();
        if(data.contains("행사")){
            hash.put("label" , "행사 목록");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "http://mydex.dongseo.ac.kr/home.edu#");
        }
        if(data.contains("진로")){
            hash.put("label" , "진로 ");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "https://www.youtube.com/watch?v=mA0qphOvyHs&feature=youtu.be");
        }
        if(data.contains("시설")){
            hash.put("label" , "시설 목록");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "http://uni.dongseo.ac.kr/sw/index.php?pCode=MN1000010");
        }
        if(data.contains("지원")){
            hash.put("label" , "YouTube");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "https://www.youtube.com/watch?v=mA0qphOvyHs&feature=youtu.be");
        }
        if(data.contains("장학금")){
            hash.put("label" , "YouTube");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "https://www.youtube.com/watch?v=mA0qphOvyHs&feature=youtu.be");
        }
        if(data.contains("배움")){
            hash.put("label" , "YouTube");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "https://www.youtube.com/watch?v=mA0qphOvyHs&feature=youtu.be");
        }
        if(data.contains("질문")){
            hash.put("label" , "입학Q&A");
            hash.put("action", "webLink");
            hash.put("webLinkUrl", "http://uni.dongseo.ac.kr/sw/index.php?pCode=MN1000019");

        }
        return null;
    }
    public String data(String data){
        Set<String> chat = manager.getData("text");
        Set<String> response ;
        for(String i : chat){
            if(data.contains(i)){
                response = manager.getData(i);
                for(String j : response) {
                    if (data.contains(j)) {
                        for(String result : manager.getData(j)){
                            return result;
                        }
                    }
                }
                for(String result : response){
                    return result;
                }
            }
        }

        return null;
    }
    public void setData(String data, String value){
        String[] label = data.split("#");
        int i =0;
        for(i =0 ; i<= label.length; i++) {
            logger.info(label[i]);
            manager.setData("text",  label[i]);
            if(i>=1){
                manager.setData(label[i-1], label[i]);
            }
        }

        manager.setResponse(label[i],value);

    }


    public Map<String, String> getbutton(String data) {
        Map<String, String> hash = manager.buttonData(data);
        hash.put("label" , "");
        hash.put("action", "webLink");
        hash.put("webLinkUrl","");

        return hash;
    }

    public void setButton(String data, String label, String webLinkUrl){
        Map<String, String> hash = manager.buttonData(data);
        hash.put("label" , "");
        hash.put("action", "webLink");
        hash.put("webLinkUrl","");

    }
}
