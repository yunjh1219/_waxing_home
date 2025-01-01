document.addEventListener("DOMContentLoaded", function() {
    const eventId = window.location.pathname.split("/").pop(); // URL에서 이벤트 ID를 추출

    if (eventId && eventId !== 'write') { // eventId가 유효한 경우에만 실행
        fetch(`/event/api/event/${eventId}/images`)
            .then(response => response.json())
            .then(imageUrls => {
                displayExistingFiles(imageUrls);
            })
            .catch(error => console.error('Error fetching event images:', error));
    }
});

function displayExistingFiles(imageUrls) {
    const existingFilesList = document.getElementById("existingFilesList");

    // 이미지 URL을 HTML로 생성
    const filesHtml = imageUrls.map(url => {
        const fileName = url.split("_").pop(); // URL에서 파일명 추출
        return `
            <li>
                <a href="${url}" target="_blank">${fileName}</a>
            </li>
        `;
    }).join('');
    existingFilesList.innerHTML = filesHtml;
}