



<!DOCTYPE html>
<html>
  <head>
    <title>Mortgage application selected</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/mortgage_application_selected/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/mortgage_application_selected/data.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="/js/json2html.js"></script>

    <script type="text/javascript">
            function postJwt() {
                    $.get( "/banks/holder", function( data ) {
                            $("#customer_name").html( data.givenName +' '+data.familyName );
                            $("#customer_address").html( data.address1 +' '+data.postCode );
                            $("#customer_phone").html( data.mobilePhone);

                    });
                    $.get( "/banks/accountInfo", function( data ) {
                            $('#accounts').html=''
                            var ul = $('<ul>').appendTo('#accounts');
                            $(data).each(function(index, item) {
                                ul.append(
                                    $(document.createElement('li'))
                                    .append(
                                        $(document.createElement("span"))
                                        .text(item.accountNumber + " " + item.sortCode)
                                    .append(
                                        $(document.createElement("table"))
                                        .innerHtml("<tr><td>test</td></tr><tr><td>test</td></tr>")
                                    )
                                );
                            });
                    });
            }
            window.onload = postJwt;
    </script>

  </head>
  <body>
    <div id="base" class="">

      <!-- Unnamed (navBar) -->

      <!-- Unnamed (Image) -->
      <div id="u274" class="ax_default image">
        <img id="u274_img" class="img " src="images/index/u3.png"/>
        <!-- Unnamed () -->
        <div id="u275" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u276" class="ax_default image">
        <img id="u276_img" class="img " src="images/index/u5.png"/>
        <!-- Unnamed () -->
        <div id="u277" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u278" class="ax_default box_1">
        <div id="u278_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u279" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u280" class="ax_default heading_2">
        <div id="u280_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u281" class="text">
          <p><span>PERSONAL</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u282" class="ax_default heading_2">
        <div id="u282_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u283" class="text">
          <p><span>PRIVATE</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u284" class="ax_default heading_2">
        <div id="u284_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u285" class="text">
          <p><span>BUSINESS</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u286" class="ax_default heading_2">
        <div id="u286_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u287" class="text">
          <p><span>INTERNATIONAL</span></p>
        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u288" class="ax_default" data-width="4" data-height="39">

        <!-- Unnamed (Vertical Line) -->
        <div id="u289" class="ax_default line">
          <img id="u289_img" class="img " src="images/index/u18.png"/>
          <!-- Unnamed () -->
          <div id="u290" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Vertical Line) -->
        <div id="u291" class="ax_default line">
          <img id="u291_img" class="img " src="images/index/u20.png"/>
          <!-- Unnamed () -->
          <div id="u292" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u293" class="ax_default" data-width="4" data-height="39">

        <!-- Unnamed (Vertical Line) -->
        <div id="u294" class="ax_default line">
          <img id="u294_img" class="img " src="images/index/u18.png"/>
          <!-- Unnamed () -->
          <div id="u295" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Vertical Line) -->
        <div id="u296" class="ax_default line">
          <img id="u296_img" class="img " src="images/index/u20.png"/>
          <!-- Unnamed () -->
          <div id="u297" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u298" class="ax_default" data-width="4" data-height="39">

        <!-- Unnamed (Vertical Line) -->
        <div id="u299" class="ax_default line">
          <img id="u299_img" class="img " src="images/index/u18.png"/>
          <!-- Unnamed () -->
          <div id="u300" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Vertical Line) -->
        <div id="u301" class="ax_default line">
          <img id="u301_img" class="img " src="images/index/u20.png"/>
          <!-- Unnamed () -->
          <div id="u302" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u303" class="ax_default" data-width="4" data-height="39">

        <!-- Unnamed (Vertical Line) -->
        <div id="u304" class="ax_default line">
          <img id="u304_img" class="img " src="images/index/u18.png"/>
          <!-- Unnamed () -->
          <div id="u305" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Vertical Line) -->
        <div id="u306" class="ax_default line">
          <img id="u306_img" class="img " src="images/index/u20.png"/>
          <!-- Unnamed () -->
          <div id="u307" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u308" class="ax_default" data-width="4" data-height="39">

        <!-- Unnamed (Vertical Line) -->
        <div id="u309" class="ax_default line">
          <img id="u309_img" class="img " src="images/index/u18.png"/>
          <!-- Unnamed () -->
          <div id="u310" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Vertical Line) -->
        <div id="u311" class="ax_default line">
          <img id="u311_img" class="img " src="images/index/u20.png"/>
          <!-- Unnamed () -->
          <div id="u312" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u313" class="ax_default heading_1">
        <div id="u313_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u314" class="text">
          <p><span>MyBank</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u315" class="ax_default box_1">
        <div id="u315_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u316" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u317" class="ax_default image">
        <img id="u317_img" class="img " src="images/mortgage_application/u209.png"/>
        <!-- Unnamed () -->
        <div id="u318" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u319" class="ax_default box_1">
        <img id="u319_img" class="img " src="images/mortgage_application_selected/u319.png"/>
        <!-- Unnamed () -->
        <div id="u320" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u321" class="ax_default heading_3">
        <div id="u321_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u322" class="text">
          <p><span>Who do you bank with?</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u323" class="ax_default box_1">
        <div id="u323_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u324" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u325" class="ax_default box_1">
        <div id="u325_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u326" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u327" class="ax_default label">
        <div id="u327_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u328" class="text">
          <p><span>Please select</span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u329" class="ax_default image">
        <img id="u329_img" class="img " src="images/mortgage_application/u221.png"/>
        <!-- Unnamed () -->
        <div id="u330" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Vertical Line) -->
      <div id="u331" class="ax_default line">
        <img id="u331_img" class="img " src="images/mortgage_application/u223.png"/>
        <!-- Unnamed () -->
        <div id="u332" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u333" class="ax_default box_1">
        <img id="u333_img" class="img " src="images/mortgage_application/u225.png"/>
        <!-- Unnamed () -->
        <div id="u334" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u335" class="ax_default box_1">
        <div id="u335_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u336" class="text">
          <p><span>Natwest</span></p>
        </div>
      </div>

      <!-- get verification button (Group) -->
      <div id="u337" class="ax_default" data-label="get verification button" data-width="223" data-height="50">

        <!-- Unnamed (Rectangle) -->
        <div id="u338" class="ax_default box_1">
          <div id="u338_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u339" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u340" class="ax_default box_1">
          <div id="u340_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u341" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u342" class="ax_default box_1">
          <div id="u342_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u343" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u344" class="ax_default heading_3">
          <div id="u344_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u345" class="text">
            <p><span><a style="text-decoration: none;" href="step3">Save and continue</a></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u346" class="ax_default box_1">
        <div id="u346_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u347" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Right Arrow Button) -->
      <div id="u348" class="ax_default box_1">
        <img id="u348_img" class="img " src="images/mortgage_application/u229.png"/>
        <!-- Unnamed () -->
        <div id="u349" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Right Arrow Button) -->
      <div id="u350" class="ax_default box_1">
        <img id="u350_img" class="img " src="images/mortgage_application/u229.png"/>
        <!-- Unnamed () -->
        <div id="u351" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Right Arrow Button) -->
      <div id="u352" class="ax_default box_1">
        <img id="u352_img" class="img " src="images/mortgage_application/u233.png"/>
        <!-- Unnamed () -->
        <div id="u353" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Dynamic Panel) -->
      <div id="u354" class="ax_default ax_default_hidden" style="display:none; visibility: hidden">
        <div id="u354_state0" class="panel_state" data-label="State1" style="">
          <div id="u354_state0_content" class="panel_state_content">

            <!-- Unnamed (Rectangle) -->
            <div id="u355" class="ax_default box_1">
              <div id="u355_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u356" class="text">
                <p><span>Natwest</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u357" class="ax_default box_1">
              <div id="u357_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u358" class="text">
                <p><span>RBS</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u359" class="ax_default box_1">
              <div id="u359_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u360" class="text">
                <p><span>HSBC</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u361" class="ax_default box_1">
              <div id="u361_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u362" class="text">
                <p><span>Barclays</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u363" class="ax_default box_1">
              <div id="u363_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u364" class="text">
                <p><span>Loyds</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u365" class="ax_default box_1">
              <div id="u365_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u366" class="text">
                <p><span>Santander</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u367" class="ax_default box_1">
              <div id="u367_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u368" class="text">
                <p><span>Metro</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u369" class="ax_default box_1">
              <div id="u369_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u370" class="text">
                <p><span>Citi</span></p>
              </div>
            </div>

            <!-- Unnamed (Rectangle) -->
            <div id="u371" class="ax_default box_1">
              <div id="u371_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u372" class="text">
                <p><span>Ulster</span></p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u373" class="ax_default heading_3">
        <div id="u373_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u374" class="text">
          <p><span>Authorise access</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u375" class="ax_default heading_3">
        <div id="u375_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u376" class="text">
          <p><span>Employment</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u377" class="ax_default heading_3">
        <div id="u377_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u378" class="text">
          <p><span>ID check</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u379" class="ax_default heading_3">
        <div id="u379_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u380" class="text">
          <p><span>Review</span></p>
        </div>
      </div>

      <!-- field (Rectangle) -->
      <div id="u381" class="ax_default box_1" data-label="field">
        <img id="u381_img" class="img " src="images/mortgage_application_selected/field_u381.png"/>
        <!-- Unnamed () -->
        <div id="u382" class="text">
        <div class="customer">
            <span>Name:</span> <span id="customer_name"></span> <br>
            <span>Address:</span> <span id="customer_address"></span> <br>
            <span>Phone number:</span> <span id="customer_phone"></span> <br>
        </div>

        <div id="accounts">

        </div>

        </div>
      </div>

      <!-- Unnamed (Group) -->
      <div id="u383" class="ax_default" data-width="41.0121933088198" data-height="42.3302127934803">

        <!-- Unnamed (Rectangle) -->
        <div id="u384" class="ax_default box_1">
          <img id="u384_img" class="img " src="images/mortgage_application_selected/u384.png"/>
          <!-- Unnamed () -->
          <div id="u385" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u386" class="ax_default box_1">
          <div id="u386_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u387" class="text" style="display:none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u388" class="ax_default box_1">
        <img id="u388_img" class="img " src="images/mortgage_application_selected/u388.png"/>
        <!-- Unnamed () -->
        <div id="u389" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Right Triangle) -->
      <div id="u390" class="ax_default box_1">
        <img id="u390_img" class="img " src="images/mortgage_application_selected/u390.png"/>
        <!-- Unnamed () -->
        <div id="u391" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>
    </div>
  </body>
</html>

