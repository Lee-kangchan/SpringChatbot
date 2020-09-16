package com.dsu.chat;

public class ChatData {

    public String request(String data){
        if(data.contains("행사")||data.contains("축제")){ return "행사";}
        if(data.contains("축제")){return "축제";}
        if(data.contains("진로")){return "진로";}
        if(data.contains("홈페이지")||data.contains("주소")||data.contains("사이트")){return "홈페이지";}
        if(data.contains("시설")){return "시설";}
        if(data.contains("미리")||data.contains("준비")||(data.contains("오기 전"))){return "준비";}
        if(data.contains("프로젝트")){return "프로젝트";}
        if(data.contains("기숙사")){return "기숙사";}
        if(data.contains("도서관")){return "도서관";}
        if(data.contains("상담신청")){return "상담신청";}
        if(data.contains("키워드")){return "키워드";}

        return "없음";
    }
    public String response(String data){
        if(data.contains("행사")){ return "행사";}
        else if(data.contains("축제")){return "축제";}
        else if(data.contains("진로")){return "진로";}
        else if(data.contains("홈페이지")){return "홈페이지";}
        else if(data.contains("시설")){return "시설";}
        else if(data.contains("미리")){return "준비";}
        else if(data.contains("프로젝트")){return "프로젝트";}
        else if(data.contains("기숙사")){return "기숙사";}
        else if(data.contains("도서관")){return "도서관";}
        else if(data.contains("상담신청")){return "상담신청";}
        else if(data.contains("키워드")){return "키워드";}
        else{return"해당내용에 답변이 없어요 ㅠㅠ 해당 내용 답변을 알고 싶으면 상담신청을 통해서 최대한 알려드리겠습니다 :) ";}
    }
}
