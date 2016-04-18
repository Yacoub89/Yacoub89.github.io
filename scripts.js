<script>
        $('#video_background').on('play', function () {
            $(this).fadeIn();
        });
        $('#video_background').on('pause ended', function () {
            $(this).fadeOut();
        });
</script>