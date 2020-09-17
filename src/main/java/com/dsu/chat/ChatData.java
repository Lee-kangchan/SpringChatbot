package com.dsu.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatData {

    public String request(String data){
        if(data.contains("행사")||data.contains("축제")){ return "행사";}
        if(data.contains("축제")){return "축제";}
        if(data.contains("진로")){return "진로";}
        if(data.contains("시설")){return "시설";}
        if(data.contains("미리")||data.contains("준비")||(data.contains("가기 전"))){return "준비";}
        if(data.contains("프로젝트")){return "프로젝트";}
        if(data.contains("기숙사")){return "기숙사";}
        if(data.contains("도서관")){return "도서관";}
        if(data.contains("상담신청")){return "상담신청";}
        if(data.contains("키워드")){return "키워드";}
        if(data.contains("튜터링")){return "튜터링";}
        if(data.contains("팁")){return "팁";}

        return "없음";
    }
    public String response(String data){
        if(data.contains("행사")){
            return "행사 종류  \n" +
                    "1. 튜터링 : (신입생 강추) 고학년 선배들이 저학년 후배들을 도움을 주는 프로그램" +
                    "2. 아이디어 경진대회 : 주로 AI와 SW를 연동한 아이디어를 가지고 발표 \n" +
                    "3. 해커톤 경진대회 : 아이디어 상품을 직접 개발하는 대회\n " +
                    "4. 기업 견학 : 다양한 기업들을 견학하는 행사\n " +
                    "이 외에 다양한 행사가 있어요 (웃음) ";
        }
        else if(data.contains("진로")){
            return "소프트웨어 학과에서는 주로 웹 개발, 앱 개발 개발 쪽을 취업을 하고 있으며 " +
                    "최근에 AI 관련된 것들이 많이 나와서 AI 전문가, 데이터 과학자 등 다양하게 진로를 선택 할 수 있어요 ";
        }
        else if(data.contains("시설")){
            return "시설은 실습을 하는 공간은 컴퓨터가 전부 설치 되어있으며 " +
                    "공부 할 수 있는 공간도 많고 연구실에 들어가면 개인 자리와 컴퓨터를" +
                    "지급 되어 편히 공부 할 수 있어요";
        }
        else if(data.contains("미리")){
            return "학교 오기전 하면 좋은 것들은 아마 처음 배우는 컴퓨터 언어는 Python 이라는 언어를 배울거에요" +
                    "이런 것들을 미리 학습을 해서 다양한 사고를 하기위해 다양한 알고리즘 문제를 푸는 것을 추천해요 " +
                    "그리고 또 하나 추천은 html css javascript를 가지고 웹페이지를 만드는 것도 추천해요 Youtube에" +
                    "좋은 영상이 올라오니 한번 참고 해보세요";
        }
        else if(data.contains("프로젝트")){
            return "프로젝트는 소프트웨어학과 홈페이지에서 선배들이 진행했던 프로젝트 목록들을 볼 수 있어요:)" +
                    "언젠가는 비슷한 프로젝트를 진행 할테니 참고하면 좋겠죠??  ";
        }
        else if(data.contains("기숙사")){
            return "기숙사는 학생생활아파트 기숙사와 글로벌 빌리지 두 기숙사가 있어요" +
                    "\n 1.학생생활아파트 : 아파트 1동에 방이 3개 정두 있는데 2인실 1인실 3인실로 되어 있으며 침대 책상 옷장을 개인으로 가지며 샤워 같은 것은 공용으로 사용해야되요 " +
                    "세탁기, 냉장고, 전자레인지 같은 것은 기숙사 안에 없으며  조리실과 세탁실은 다른 동에 공용으로 사용하는 곳이 있어요" +
                    "\n 2.글로벌빌리지 : 글로벌빌리지는 전부 2인실로 되어 있으며 가격이 20만원? 정도 비싸니깐 학생생활아파트보다는 시설이 좀 더 좋을 거에요 포함하는 건 학생 생활" +
                    "아파트랑 비슷하며 조리실은 없어요  " +
                    "\n 자세한 것은 학교 홈페이지를 참고해주세요 :)";
        }
        else if(data.contains("도서관")){
            return "도서관 대한 정보는 없어 동서대학교 민석도서관 홈페이지를 한번 참고해보세요 ㅠㅠ ";}
        else if(data.contains("상담신청")){return "상담신청";}
        else if(data.contains("키워드")){return "키워드";}
        else if(data.contains("팁")){return "";}
        else{return"해당내용에 답변이 없어요 ㅠㅠ 해당 내용 답변을 알고 싶으면 상담신청을 통해서 최대한 알려드리겠습니다 :) ";}
    }
    public HashMap<String,Object> list(String data){
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
        quickRepl4.put("label","미리");
        quickRepl4.put("messageText","미리");
        quickReplies.add(quickRepl4);

        HashMap<String,Object> quickRepl5 = new HashMap<>();
        quickRepl5.put("action","message");
        quickRepl5.put("label","프로젝트");
        quickRepl5.put("messageText","프로젝트");
        quickReplies.add(quickRepl5);

        HashMap<String,Object> quickRepl6 = new HashMap<>();
        quickRepl6.put("action","message");
        quickRepl6.put("label","기숙사");
        quickRepl6.put("messageText","기숙사");
        quickReplies.add(quickRepl6);

        HashMap<String,Object> quickRepl7 = new HashMap<>();
        quickRepl7.put("action","message");
        quickRepl7.put("label","도서관");
        quickRepl7.put("messageText","도서관");
        quickReplies.add(quickRepl7);

        HashMap<String,Object> quickRepl8 = new HashMap<>();
        quickRepl8.put("action","message");
        quickRepl8.put("label","상담신청");
        quickRepl8.put("messageText","상담신청");
        quickReplies.add(quickRepl8);

        HashMap<String,Object> quickRepl9 = new HashMap<>();
        quickRepl9.put("action","message");
        quickRepl9.put("label","팁");
        quickRepl9.put("messageText","팁");
        quickReplies.add(quickRepl9);

    }
}
