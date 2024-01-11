function deleteCoverImage(coverId) {
    fetch('/api/cover/' + coverId, {
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
        console.error('Error:', error);
    });
}


function deleteComment(commentId) {
    fetch('/api/comment/'+commentId, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(response => {
        if(response.ok) {
            alert('소개말을 성공적으로 삭제했습니다.');
        } else {
            // 오류 처리
            alert('소개말을 삭제하는데 실패했습니다.');
        }
        window.location.reload();
    }).catch(error => {
        console.error('Error:', error);
    });
}
