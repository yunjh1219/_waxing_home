window.addEventListener('scroll', function() {
    var elements = document.querySelectorAll('.middle-top-text h1, .middle-middle-text h1, .middle-bottom-text h1,' +
        '.middle-top-text h3, .middle-middle-text h3, .middle-bottom-text h3' +
        '.middle-top-text h2, .middle-middle-text h2, .middle-bottom-text h2');

    elements.forEach(function(element) {
        var rect = element.getBoundingClientRect(); // 요소의 위치 정보 가져오기
        if (rect.top < window.innerHeight && rect.bottom >= 0) { // 화면에 보일 때
            element.style.opacity = 1; // 보이게 설정
            element.style.transform = 'translateY(0)'; // 원래 위치로 이동
        }
    });
});