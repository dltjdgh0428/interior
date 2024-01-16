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

