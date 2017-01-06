This is my Website Profile builtd in Angula2 as a SPA.

Git hub doe not host a SPA properly so I had ot hack it.

Here is what i did:

1) create a 404.html page and add this:
 -->
 <!doctype html>
<html>
  <head>
    <!-- This stores the URL the user was attempting to go to in sessionStorage,
    and then redirects all 404 responses to the app’s index.html page -->
    <!-- See http://www.backalleycoder.com/2016/05/13/sghpa-the-single-page-app-hack-for-github-pages/ -->
    <script>
      sessionStorage.redirect = location.href;
    </script>
    <meta http-equiv="refresh" content="0;URL='https://USERNAME.github.io/PROJECT_NAME'"></meta>
  </head>
  <body>
  </body>
</html>

2) then in the index.html I added this in side the head tag
-->
<script>
  // See http://www.backalleycoder.com/2016/05/13/sghpa-the-single-page-app-hack-for-github-pages/
  (function(){
    var redirect = sessionStorage.redirect;
    delete sessionStorage.redirect;
    if (redirect && redirect != location.href) {
      history.replaceState(null, null, redirect);
    }
  })();
</script>

Source:
http://www.backalleycoder.com/2016/05/13/sghpa-the-single-page-app-hack-for-github-pages/
