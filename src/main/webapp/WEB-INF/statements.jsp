<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
        function postJwt() {
                $.get( "/banks/holder", function( data ) {
                        $("customer").html( data );
                });
                $.get( "/banks/accountInfo", function( data ) {
                        $("accounts").html( data );
                });
        }
        window.onload = postJwt;
</script>

<h1>We're calculating some money type stuffs</h1>

<div id="customer">

</div>

<div id="accounts"></div>
