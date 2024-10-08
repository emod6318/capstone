var calendar;

document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            selectable: true,
            dateClick: function (info) {
                console.log("Clicked event occurs : date = " + info.dateStr);
           },
    });
    calendar.render();



     // 모달 생성
     const modalOpen = document.querySelector('.makeToDoModalOpenBtn');
     const modalClose = document.querySelector('.makeToDoModalCloseBtn');
     const modalSave = document.querySelector('.makeToDoModalSaveBtn');
     const modal = document.querySelector('.modal');


     // 열기 버튼을 눌렀을 때 모달팝업이 열림
     modalOpen.addEventListener('click',function(){
         //'on' class 추가
         modal.classList.add('on');
     });
     // 닫기 버튼을 눌렀을 때 모달팝업이 닫힘
     modalClose.addEventListener('click',function(){
         //'on' class 제거
         modal.classList.remove('on');
     });
     // 저장 버튼을 눌렀을 때 모달팝업이 닫힘
     modalSave.addEventListener('click',function(){
         //'on' class 제거
         modal.classList.remove('on');
     });

});

// 날짜 클릭 이벤트
function chooseDayEvent(date) {
    const chooseDay = document.querySelector('.chooseDay');
    chooseDay.set(date);

}


