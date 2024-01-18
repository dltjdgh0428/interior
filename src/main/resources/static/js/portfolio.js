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

