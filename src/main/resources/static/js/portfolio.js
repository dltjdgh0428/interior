function deletePortfolioImage(imageId) {
    fetch('/api/portfolio/' + imageId, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => {
        if(response.ok) {
            alert('이미지를 성공적으로 삭제했습니다.');
        } else {
            alert('이미지를 삭제하는데 문제가 발생했습니다.');
        }
        window.location.reload();
    })
    .catch(error => {
        console.error('There was an error!', error);
    });
}
function openOverlay(albumId) {
    fetch('/api/album/'+albumId)
    .then(response => response.json())
    .then(data => {
    window.location.href=`/album/${albumId}`;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
// 포트폴리오.js

//function openOverlay(albumId) {
//    // 오버레이 요소 생성 및 스타일 설정
//    var overlay = document.createElement('div');
//    overlay.className = 'overlay';
//    document.body.appendChild(overlay);
//
//    // 오버레이 컨텐츠 생성 및 스타일 설정
//    var overlayContent = document.createElement('div');
//    overlayContent.className = 'overlay-content';
//    overlay.appendChild(overlayContent);
//
//    // 닫기 버튼 생성
//    var closeButton = document.createElement('button');
//    closeButton.className = 'btn-close';
//    closeButton.innerText = '닫기';
//    closeButton.onclick = function () {
//        document.body.removeChild(overlay);
//    };
//    overlayContent.appendChild(closeButton);
//
//    // AJAX 요청으로 앨범 데이터 로드
//    fetch(`/api/album/${albumId}`)
//        .then(response => response.json())
//        .then(data => {
//            // 앨범 캐러셀에 이미지 추가
//            overlayContent.innerHTML = `
//                <div class="container">
//                    <div id="albumCarousel" class="carousel slide" data-bs-ride="carousel">
//                        <div class="carousel-inner">
//                            ${albumImages}
//                        </div>
//                        <button class="carousel-control-prev" type="button" data-bs-target="#albumCarousel"
//                                data-bs-slide="prev">
//                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
//                            <span class="visually-hidden">Previous</span>
//                        </button>
//                        <button class="carousel-control-next" type="button" data-bs-target="#albumCarousel"
//                                data-bs-slide="next">
//                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
//                            <span class="visually-hidden">Next</span>
//                        </button>
//                    </div>
//                </div>
//            `;
//
//            // 오버레이를 보이도록 설정
//            overlay.style.display = 'block';
//        })
//        .catch(error => {
//            console.error('Error:', error);
//        });
//}
