
<!-- Naver Map API  -->
var map = null;

function initMap() {
    // 강남 좌표로 지도를 초기화
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(37.517236, 127.047325), // 강남 좌표
        zoom: 13 // 초기 확대 수준
    });

    // 마커 생성
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.3595704, 127.105399),  // 마커 위치
        map: map,
        title: '여기에 제목 입력',

    });


    // 마커 위치로 지도를 이동시키고, 확대 수준을 14로 설정
    map.setCenter(marker.getPosition());
    map.setZoom(16); // 확대 레벨을 14로 설정

}