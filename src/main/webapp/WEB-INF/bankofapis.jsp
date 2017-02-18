<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
        function postJwt() {
            window.location = "banks/setjwt?id_token=" + window.location.hash.replace("#id_token=","")
        }
        window.onload = postJwt;
</script>
