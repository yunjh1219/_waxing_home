window.addEventListener('scroll', debounce(function() {
    var elements = document.querySelectorAll(
        '.middle-top-text h1, .middle-middle-text h1, .middle-bottom-text h1, ' +
        '.middle-top-text h2, .middle-middle-text h2, .middle-bottom-text h2, ' +
        '.middle-top-text h3, .middle-middle-text h3, .middle-bottom-text h3'
    );

    elements.forEach(function(element) {
        var rect = element.getBoundingClientRect();

        // 화면에 보일 때
        if (rect.top < window.innerHeight && rect.bottom >= 0) {
            element.style.opacity = '1';
            element.style.transform = 'translateY(0)';
        }
        // 화면에서 사라질 때
        else {
            element.style.opacity = '0';
            element.style.transform = 'translateY(20px)';
        }
    });
}, 100)); // 100ms 딜레이를 추가하여 성능 최적화

// 디바운스 함수 (성능 최적화를 위해 추가)
function debounce(func, delay) {
    let timer;
    return function() {
        clearTimeout(timer);
        timer = setTimeout(func, delay);
    };
}

document.addEventListener('DOMContentLoaded', function () {
    var map = L.map('map').setView([37.5665, 126.9780], 13); // 서울 시청 좌표
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19
    }).addTo(map);

    // 마커 추가
    L.marker([37.5665, 126.9780]).addTo(map)
        .bindPopup('<b>서울 시청</b><br>여기에 표시됩니다.')
        .openPopup();
});


