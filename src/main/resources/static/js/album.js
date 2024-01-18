function deletePortfolioAlbum(albumId) {
    fetch('/api/album/' + albumId, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => {
        if(response.ok) {
            alert('앨범를 성공적으로 삭제했습니다.');
        } else {
            alert('앨범를 삭제하는데 문제가 발생했습니다.');
        }
         window.location.href=`/portfolio`;
    })
    .catch(error => {
        console.error('There was an error!', error);
    });
}

function editCaption(albumId) {
    var newCaption = document.getElementById('newCaption').value;

    fetch('/api/album/editCaption/' + albumId, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ caption: newCaption })
    })
    .then(response => {
        if(response.ok) {
            alert('설명을 성공적으로 수정했습니다.');
            window.location.reload();
        } else {
            alert('설명 수정에 실패했습니다.');
        }
    })
    .catch(error => {
        console.error('There was an error!', error);
    });
}
